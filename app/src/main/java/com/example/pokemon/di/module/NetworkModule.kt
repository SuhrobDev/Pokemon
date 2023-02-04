package com.example.pokemon.di.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.pokemon.R
import com.example.pokemon.utils.getString
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule(val context: Context) {

    @Singleton
    @Provides
    fun provideGsonConvertorFactory(): GsonConverterFactory = GsonConverterFactory.create()
//
//    @Singleton
//    @Provides
//    fun provideEncryptedSharedPreference(): EncryptedSharedPref =
//        EncryptedSharedPref(context)

    @Singleton
    @Provides
    fun provideOkHttpClient(
//        encryptedSharedPref: EncryptedSharedPref
    ): OkHttpClient {
        val chuckInterceptor = ChuckerInterceptor.Builder(context)
            .maxContentLength(500_000L)
            .alwaysReadResponseBody(true)
            .build()
//        Log.d("LLLLLL", "provideOkHttpClient: ${encryptedSharedPref.getToken()}")
        val builder = OkHttpClient.Builder()
            .addInterceptor(chuckInterceptor)
            .connectTimeout(10000L, TimeUnit.SECONDS)
            .addNetworkInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request = chain.request().newBuilder()
//                    .addHeader("Authorization", "Bearer ${encryptedSharedPref.getToken()}")
//                    .addHeader("language", encryptedSharedPref.getLanguage())
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build()
                chain.proceed(request)
            })
            .build()
        return builder
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonGsonConverterFactory: GsonConverterFactory,
        builder: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getString(R.string.base_url))
            .client(builder)
            .addConverterFactory(gsonGsonConverterFactory)
            .build()
    }

//    @Singleton
//    @Provides
//    fun provideSocket(
//        okHttpClient: OkHttpClient,
//        encryptedSharedPref: EncryptedSharedPref
//    ): Socket {
//        val options = IO.Options()
//        val mutableMap = mutableMapOf<String, List<String>>()
//        mutableMap["authorization"] = mutableListOf(encryptedSharedPref.getToken())
//        options.forceNew = true
//        options.reconnection = true
//        options.reconnectionDelay = 1000
//        options.path = "/socket.io"
//        options.extraHeaders = mutableMap
//        options.callFactory = okHttpClient
//        return IO.socket("http://5.161.134.59:8800", options)
//    }
}