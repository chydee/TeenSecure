package com.j0t1m4.teensecure.core

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModuleDI {

    @Singleton
    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context) = SharedPreferences(context)

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.teensec)
            .error(R.drawable.teensec)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

}