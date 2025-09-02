package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.PaymentDao
import com.example.comida.domain.usecase.PaymentUseCase
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PaymentRepository @Inject constructor(
    private val paymentUseCase: PaymentUseCase,
    private val appCoroutineScope: AppCoroutineScope
): PaymentDao {

    init {
        fetchDummyPayments()
    }

    private fun fetchDummyPayments(){}
}