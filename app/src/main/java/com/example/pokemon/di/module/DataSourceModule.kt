package com.example.pokemon.di.module

import com.example.data.remote.MainService
import dagger.Module
import dagger.Provides
import com.example.data.repository.datasource.MainRemoteDatasource
import com.example.data.repository.datasource.MainRemoteDatasourceImpl
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(mainApiService: MainService): MainRemoteDatasource {
        return MainRemoteDatasourceImpl(mainApiService)
    }

//    @Provides
//    @Singleton
//    fun provideAuthDataSource(authApiService: AuthService): AuthRemoteDatasource {
//        return AuthRemoteDatasourceImpl(authApiService)
//    }

}