package com.example.comida.di

import com.example.comida.domain.repository.AppNotificationRepository
import com.example.comida.domain.repository.CartRepository
import com.example.comida.domain.repository.FoodRepository
import com.example.comida.domain.repository.OrdersRepository
import com.example.comida.domain.repository.PaymentRepository
import com.example.comida.domain.repository.RestaurantsRepository
import com.example.comida.domain.repository.SpecialOfferRepository
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
object RepositoryModule {

    @Singleton
    @Provides
    fun providesAppNotificationRepository(
        notificationsUseCase: NotificationsUseCase
    ) : AppNotificationRepository {
        return AppNotificationRepository(
            notificationsUseCase = notificationsUseCase
        )
    }

    @Singleton
    @Provides
    fun providesCartRepository(
        cartUseCase: CartUseCase
    ) : CartRepository {
        return CartRepository(
            cartUseCase = cartUseCase
        )
    }

    @Singleton
    @Provides
    fun providesFoodRepository(
        foodUseCase: FoodUseCase
    ) : FoodRepository {
        return FoodRepository(
            foodUseCase = foodUseCase
        )
    }

    @Singleton
    @Provides
    fun providesOrdersRepository(
        ordersUseCase: OrdersUseCase
    ) : OrdersRepository {
        return OrdersRepository(
            ordersUseCase = ordersUseCase
        )
    }

    @Singleton
    @Provides
    fun providesRestaurantRepository(
        restaurantsUseCase: RestaurantsUseCase
    ) : RestaurantsRepository {
        return RestaurantsRepository(
            restaurantsUseCase = restaurantsUseCase
        )
    }

    @Singleton
    @Provides
    fun providesSpecialOfferRepository(
        specialOffersUseCase: SpecialOffersUseCase
    ) : SpecialOfferRepository {
        return SpecialOfferRepository(
            specialOffersUseCase = specialOffersUseCase
        )
    }

    @Singleton
    @Provides
    fun providesPaymentRepository(
        paymentUseCase: PaymentUseCase
    ) : PaymentRepository {
        return PaymentRepository(
            paymentUseCase = paymentUseCase
        )
    }
}