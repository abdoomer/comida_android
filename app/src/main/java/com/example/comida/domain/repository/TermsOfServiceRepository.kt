package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.TermsOfServiceDao
import com.example.comida.domain.usecase.TermsOfServiceUseCase
import com.example.comida.models.ResourceResult
import com.example.comida.models.profile.TermsOfService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TermsOfServiceRepository @Inject constructor(
    private val termsOfServiceUseCase: TermsOfServiceUseCase,
    private val appCoroutineScope: AppCoroutineScope
): TermsOfServiceDao {

    private val _termsOfService: MutableStateFlow<TermsOfService> = MutableStateFlow(TermsOfService())

    init {
        fetchTermsOfService()
    }

    override fun fetchTermsOfService() {
        appCoroutineScope.launch {
            termsOfServiceUseCase().collect { result ->
                when(result){
                    is ResourceResult.Success -> {
                        _termsOfService.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun getTermsOfService(): TermsOfService {
        return _termsOfService.value
    }
}