package com.example.comida.di

import android.content.Context
import android.content.SharedPreferences
import com.example.comida.ComidaApp
import com.example.comida.services.ComidaSharedPreferences
import com.example.comida.viewmodels.ComidaViewmodel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ComidaAppModule {

    @Provides
    @Singleton
    fun provideComidaApplication(@ApplicationContext context: Context): ComidaApp {
        return context as ComidaApp
    }

    @Singleton
    @Provides
    fun providesSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences("comida", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun providesComidaSharedPreferences(
        sharedPreferences: SharedPreferences,
    ): ComidaSharedPreferences {
        return ComidaSharedPreferences(
            sharedPreferences = sharedPreferences
        )
    }
}