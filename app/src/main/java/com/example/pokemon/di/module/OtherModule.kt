package com.example.pokemon.di.module

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.pokemon.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OtherModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideGlideInstance(
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(AppCompatResources.getDrawable(context, R.drawable.ic_launcher_background))
            .error(AppCompatResources.getDrawable(context, R.drawable.ic_launcher_background))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
}
