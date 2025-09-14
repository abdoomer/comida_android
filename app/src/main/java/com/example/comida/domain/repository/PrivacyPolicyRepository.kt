package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.PrivacyPolicyDao
import com.example.comida.domain.usecase.PrivacyPolicyUseCase
import com.example.comida.models.PrivacyPolicy
import com.example.comida.models.ResourceResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PrivacyPolicyRepository @Inject constructor(
    private val privacyPolicyUseCase: PrivacyPolicyUseCase,
    private val appCoroutineScope: AppCoroutineScope
): PrivacyPolicyDao {

    private val _privacyPolicy: MutableStateFlow<PrivacyPolicy> = MutableStateFlow(PrivacyPolicy())

    override fun fetchPrivacyPolicy() {
        appCoroutineScope.launch {
            privacyPolicyUseCase().collect { result ->
                when(result){
                    is ResourceResult.Success -> {
                        _privacyPolicy.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> {}
                }
            }
        }
    }
}