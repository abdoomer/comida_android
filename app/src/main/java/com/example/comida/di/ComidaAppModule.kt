package com.example.comida.di

import android.content.Context
import android.content.SharedPreferences
import com.example.comida.ComidaApp
import com.example.comida.domain.usecase.CartUseCase
import com.example.comida.domain.usecase.FoodUseCase
import com.example.comida.domain.usecase.NotificationsUseCase
import com.example.comida.domain.usecase.OrdersUseCase
import com.example.comida.domain.usecase.PaymentUseCase
import com.example.comida.domain.usecase.RestaurantsUseCase
import com.example.comida.domain.usecase.SpecialOffersUseCase
import com.example.comida.services.ComidaSharedPreferences
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

    @Singleton
    @Provides
    fun providesFoodCategoryUseCase() : FoodUseCase {
        return FoodUseCase()
    }

    @Singleton
    @Provides
    fun providesNotificationsUseCase() : NotificationsUseCase {
        return NotificationsUseCase()
    }

    @Singleton
    @Provides
    fun providesRestaurantsUseCase() : RestaurantsUseCase {
        return RestaurantsUseCase()
    }

    @Singleton
    @Provides
    fun providesSpecialOffersUseCase() : SpecialOffersUseCase {
        return SpecialOffersUseCase()
    }

    @Singleton
    @Provides
    fun providesCartUseCase() : CartUseCase {
        return CartUseCase()
    }

    @Singleton
    @Provides
    fun providesOrdersUseCase() : OrdersUseCase {
        return OrdersUseCase()
    }

    @Singleton
    @Provides
    fun providesPaymentUseCase() : PaymentUseCase {
        return PaymentUseCase()
    }
}