package com.example.comida.di

import com.example.comida.domain.usecase.CartUseCase
import com.example.comida.domain.usecase.FoodUseCase
import com.example.comida.domain.usecase.NotificationsUseCase
import com.example.comida.domain.usecase.OrdersUseCase
import com.example.comida.domain.usecase.PaymentUseCase
import com.example.comida.domain.usecase.RestaurantsUseCase
import com.example.comida.domain.usecase.SpecialOffersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesCartUseCase() : CartUseCase {
        return CartUseCase()
    }

    @Singleton
    @Provides
    fun providesFoodUseCase() : FoodUseCase {
        return FoodUseCase()
    }

    @Singleton
    @Provides
    fun providesNotificationsUseCase() : NotificationsUseCase {
        return NotificationsUseCase()
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

}