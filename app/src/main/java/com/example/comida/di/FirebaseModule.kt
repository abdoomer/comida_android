package com.example.comida.di

import android.content.Context
import com.example.comida.domain.repository.AuthenticationRepository
import com.example.comida.domain.repository.FBDatabaseRepository
import com.example.comida.domain.repository.FirebaseRepository
import com.example.comida.domain.repository.RealTimeRepository
import com.google.android.gms.auth.api.identity.Identity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Singleton
    @Provides
    fun providesFirebaseRepository(
        appCoroutineScope: AppCoroutineScope,
        @ApplicationContext context: Context
    ): FirebaseRepository{
        return FirebaseRepository(
            appCoroutineScope = appCoroutineScope,
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    @Singleton
    @Provides
    fun providesAuthenticationRepository(
        firebaseRepository: FirebaseRepository
    ): AuthenticationRepository {
        return AuthenticationRepository(
            firebaseRepository = firebaseRepository
        )
    }

    @Singleton
    @Provides
    fun providesFBDatabaseRepository(
        appCoroutineScope: AppCoroutineScope,
        firebaseRepository: FirebaseRepository
    ): FBDatabaseRepository {
        return FBDatabaseRepository(
            appCoroutineScope = appCoroutineScope,
            firebaseRepository = firebaseRepository
        )
    }

    @Singleton
    @Provides
    fun providesRealTimeRepository(
        appCoroutineScope: AppCoroutineScope,
        firebaseRepository: FirebaseRepository
    ): RealTimeRepository {
        return RealTimeRepository(
            appCoroutineScope = appCoroutineScope,
            firebaseRepository = firebaseRepository
        )
    }
}