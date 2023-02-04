package com.example.pokemon.di.module

import com.example.data.repository.MainRepositoryImpl
import com.example.data.repository.datasource.MainRemoteDatasource
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(mainRemoteDataSource: MainRemoteDatasource): MainRepository {
        return MainRepositoryImpl(mainRemoteDataSource)
    }

}