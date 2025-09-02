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
        notificationsUseCase: NotificationsUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : AppNotificationRepository {
        return AppNotificationRepository(
            notificationsUseCase = notificationsUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }

    @Singleton
    @Provides
    fun providesCartRepository(
        cartUseCase: CartUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : CartRepository {
        return CartRepository(
            cartUseCase = cartUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }

    @Singleton
    @Provides
    fun providesFoodRepository(
        foodUseCase: FoodUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : FoodRepository {
        return FoodRepository(
            foodUseCase = foodUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }

    @Singleton
    @Provides
    fun providesOrdersRepository(
        ordersUseCase: OrdersUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : OrdersRepository {
        return OrdersRepository(
            ordersUseCase = ordersUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }

    @Singleton
    @Provides
    fun providesRestaurantRepository(
        restaurantsUseCase: RestaurantsUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : RestaurantsRepository {
        return RestaurantsRepository(
            restaurantsUseCase = restaurantsUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }

    @Singleton
    @Provides
    fun providesSpecialOfferRepository(
        specialOffersUseCase: SpecialOffersUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : SpecialOfferRepository {
        return SpecialOfferRepository(
            specialOffersUseCase = specialOffersUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }

    @Singleton
    @Provides
    fun providesPaymentRepository(
        paymentUseCase: PaymentUseCase,
        appCoroutineScope: AppCoroutineScope
    ) : PaymentRepository {
        return PaymentRepository(
            paymentUseCase = paymentUseCase,
            appCoroutineScope = appCoroutineScope
        )
    }
}