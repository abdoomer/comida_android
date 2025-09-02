package com.example.comida.models

import java.util.UUID


data class OrderPayment(
    val id: String = UUID.randomUUID().toString()
)
