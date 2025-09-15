package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.RealTimeDao
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RealTimeRepository @Inject constructor(
    private val appCoroutineScope: AppCoroutineScope,
    private val firebaseRepository: FirebaseRepository
) : RealTimeDao {
}