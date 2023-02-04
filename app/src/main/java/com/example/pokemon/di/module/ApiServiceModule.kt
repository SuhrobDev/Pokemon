package com.example.pokemon.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import com.example.data.remote.MainService
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Singleton
    @Provides
    fun provideMainService(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)

//    @Singleton
//    @Provides
//    fun provideCourseService(retrofit: Retrofit): CourseService =
//        retrofit.create(CourseService::class.java)
//
//    @Singleton
//    @Provides
//    fun provideAuthService(retrofit: Retrofit): AuthService =
//        retrofit.create(AuthService::class.java)

}