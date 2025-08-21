package com.example.comida.models




sealed interface OTPAction {
    data class OnEnterNumber(val number: Int?, val index: Int): OTPAction
    data class OnChangedFieldFocused(val index: Int): OTPAction
    data object OnKeyboardBackButtonPressed: OTPAction
}