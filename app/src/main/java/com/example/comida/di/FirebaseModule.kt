package com.example.comida.di

import android.content.Context
import com.example.comida.domain.repository.AuthenticationRepository
import com.example.comida.domain.repository.FBDatabaseRepository
import com.example.comida.domain.repository.FBRealtimeDatabaseRepository
import com.example.comida.domain.repository.FirebaseRepository
import com.example.comida.domain.repository.RealTimeRepository
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
        )
    }

    @Singleton
    @Provides
    fun providesAuthenticationRepository(
        firebaseRepository: FirebaseRepository,
        appCoroutineScope: AppCoroutineScope,
    ): AuthenticationRepository {
        return AuthenticationRepository(
            firebaseRepository = firebaseRepository,
            appCoroutineScope = appCoroutineScope
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

    @Singleton
    @Provides
    fun providesFBRealtimeDatabaseRepository(
        appCoroutineScope: AppCoroutineScope,
        firebaseRepository: FirebaseRepository
    ): FBRealtimeDatabaseRepository {
        return FBRealtimeDatabaseRepository(
            firebaseRepository = firebaseRepository,
            appCoroutineScope = appCoroutineScope
        )
    }
}