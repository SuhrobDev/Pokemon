package com.example.pokemon.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.local.room.AppDatabase
import com.example.data.local.room.dao.InputDao
import com.example.data.local.room.dao.RemoteKeysDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "sample_task")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUssdDao(appDatabase: AppDatabase): InputDao = appDatabase.inputDao()

    @Provides
    @Singleton
    fun provide(appDatabase: AppDatabase): RemoteKeysDao = appDatabase.remoteDao()
}