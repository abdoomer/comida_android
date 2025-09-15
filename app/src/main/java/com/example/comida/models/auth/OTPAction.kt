package com.example.comida.models.auth




sealed interface OTPAction {
    data class OnEnterNumber(val number: Int?, val index: Int): OTPAction
    data class OnChangedFieldFocused(val index: Int): OTPAction
    data object OnKeyboardBackButtonPressed: OTPAction
}