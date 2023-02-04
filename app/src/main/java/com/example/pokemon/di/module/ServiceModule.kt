package com.example.pokemon.di.module

import android.content.Context
import com.bumptech.glide.util.Util
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule(private val context: Context) {

//    @Singleton
//    @Provides
//    fun provideAudioAttributes() = AudioAttributes.Builder()
//        .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
//        .setUsage(C.USAGE_MEDIA)
//        .build()
//
//    @Provides
//    @Singleton
//    fun provideExoPlayer(
//        audioAttributes: AudioAttributes
//    ) = SimpleExoPlayer.Builder(context).build().apply {
//        setAudioAttributes(audioAttributes, true)
//        setHandleAudioBecomingNoisy(true)
//    }
//
//    @Provides
//    @Singleton
//    fun provideDataSourceFactory(
//    ) = DefaultDataSourceFactory(
//        context,
//        Util.getUserAgent(context, context.resources.getString(R.string.app_name))
//    )


}