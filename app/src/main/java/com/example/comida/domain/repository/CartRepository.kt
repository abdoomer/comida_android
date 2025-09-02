package com.example.comida.domain.repository

import com.example.comida.domain.dao.CartDao
import com.example.comida.domain.usecase.CartUseCase
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CartRepository @Inject constructor(
    private val cartUseCase: CartUseCase
): CartDao {
}