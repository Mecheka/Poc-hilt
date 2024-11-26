package com.meckeka.poc.hilt.di

import com.meckeka.poc.hilt.poc.PocInject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PocModule {

    @Provides
    fun providesPocInject() = PocInject()
}