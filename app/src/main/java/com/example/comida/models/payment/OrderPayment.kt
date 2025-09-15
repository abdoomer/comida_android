package com.example.comida.models.payment

import java.util.UUID

data class OrderPayment(
    val id: String = UUID.randomUUID().toString()
)