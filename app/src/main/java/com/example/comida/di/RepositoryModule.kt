package com.example.comida.di

import com.example.comida.domain.repository.AppNotificationRepository
import com.example.comida.domain.repository.CartRepository
import com.example.comida.domain.repository.FoodRepository
import com.example.comida.domain.repository.OrdersRepository
import com.example.comida.domain.repository.PaymentRepository
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.domain.repository.SpecialOfferRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesAppNotificationRepository() : AppNotificationRepository {
        return AppNotificationRepository()
    }

    @Singleton
    @Provides
    fun providesCartRepository() : CartRepository {
        return CartRepository()
    }

    @Singleton
    @Provides
    fun providesFoodRepository() : FoodRepository {
        return FoodRepository()
    }

    @Singleton
    @Provides
    fun providesOrdersRepository() : OrdersRepository {
        return OrdersRepository()
    }

    @Singleton
    @Provides
    fun providesRestaurantRepository() : RestaurantsRepository {
        return RestaurantsRepository()
    }

    @Singleton
    @Provides
    fun providesSpecialOfferRepository() : SpecialOfferRepository {
        return SpecialOfferRepository()
    }

    @Singleton
    @Provides
    fun providesPaymentRepository() : PaymentRepository {
        return PaymentRepository()
    }
}