package com.example.comida.models



data class OTPState(
    val otpCode: List<Int?> = (1 .. 4).map { null },
    val focusedIndex: Int? = null,
    val isValid: Boolean? = null
)
