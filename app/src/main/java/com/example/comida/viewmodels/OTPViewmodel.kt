package com.example.comida.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comida.models.OTPAction
import com.example.comida.models.OTPState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


const val VALID_OTP_CODE = "1414"
class OTPViewmodel(

): ViewModel() {

    private val _otpState: MutableStateFlow<OTPState> = MutableStateFlow(OTPState())
    val otpState: StateFlow<OTPState> = _otpState


    fun onAction(action: OTPAction){
        viewModelScope.launch {
            when(action){
                is OTPAction.OnChangedFieldFocused -> {
                    _otpState.update {
                        it.copy(focusedIndex = action.index)
                    }
                }

                is OTPAction.OnEnterNumber -> {
                    enterNumber(action.number, action.index)
                }

                is OTPAction.OnKeyboardBackButtonPressed -> {
                    val previousIndex = getPreviousFocusedIndex(otpState.value.focusedIndex)

                    _otpState.update {
                        it.copy(
                            otpCode = it.otpCode.mapIndexed { index, number ->
                                if (index == previousIndex){
                                    null
                                } else {
                                    number
                                }
                            },
                            focusedIndex = previousIndex
                        )
                    }
                }
            }
        }
    }

    private fun enterNumber(number: Int?, index: Int) {
        val newCode = otpState.value.otpCode.mapIndexed { currentIndex, currentNumber ->
            if (currentIndex == index) {
                number
            } else {
                currentNumber
            }
        }

        val wasNumberRemoved = number == null

        _otpState.update {
            it.copy(
                otpCode = newCode,
                focusedIndex = if (wasNumberRemoved || it.otpCode.getOrNull(index) != null) {
                    it.focusedIndex
                } else {
                    getNextFocusedTextFieldIndex(
                        currentCode = it.otpCode,
                        currentFocusedIndex = it.focusedIndex
                    )
                },
                isValid = if (newCode.none{ it == null }) {
                    newCode.joinToString("") == VALID_OTP_CODE
                } else null
            )
        }
    }

    private fun getPreviousFocusedIndex(currentIndex: Int?) : Int? {
        return currentIndex?.minus(1)?.coerceAtLeast(0)
    }

    private fun getNextFocusedIndex(currentIndex: Int?) : Int? {
        return currentIndex?.plus(1)
    }

    private fun getNextFocusedTextFieldIndex(
        currentCode: List<Int?>,
        currentFocusedIndex: Int?
    ) : Int? {
        if (currentFocusedIndex == null){
            return null
        }

        if (currentFocusedIndex == 3){
            return currentFocusedIndex
        }

        return getFirstEmptyFieldIndexAfterFocusedIndex(
            otp = currentCode,
            currentFocusedIndex = currentFocusedIndex
        )
    }

    private fun getFirstEmptyFieldIndexAfterFocusedIndex(
        otp: List<Int?>,
        currentFocusedIndex: Int
    ): Int {
        otp.forEachIndexed { index, number ->
            if (index <= currentFocusedIndex){
                return@forEachIndexed
            }

            if (number == null){
                return index
            }
        }

        return currentFocusedIndex
    }

    fun verifyOTPCode(){}

    fun resendOTPCode(){}
}