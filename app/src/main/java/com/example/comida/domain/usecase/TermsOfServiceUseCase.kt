package com.example.comida.domain.usecase

import com.example.comida.dummy.termsOfService.dummyTermsOfService
import com.example.comida.models.ResourceResult
import com.example.comida.models.profile.TermsOfService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TermsOfServiceUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<TermsOfService>> =
        flow {

            emit(ResourceResult.Loading)

            try {
                emit(ResourceResult.Success(dummyTermsOfService))
            } catch (e: Exception){
                emit(ResourceResult.Error(e))
            }

        }.flowOn(Dispatchers.IO)
}