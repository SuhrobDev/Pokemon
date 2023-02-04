package com.example.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.room.dao.InputDao
import com.example.data.local.room.dao.RemoteKeysDao
import com.example.domain.model.PokemonModel

@Database(entities = [PokemonModel::class, RemoteKeys::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun inputDao(): InputDao
    abstract fun remoteDao(): RemoteKeysDao
}