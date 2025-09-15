package com.example.comida.domain.usecase

import com.example.comida.dummy.privacyPolicy.dummyPrivacyPolicy
import com.example.comida.models.profile.PrivacyPolicy
import com.example.comida.models.ResourceResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PrivacyPolicyUseCase @Inject constructor() {

    operator fun invoke(): Flow<ResourceResult<PrivacyPolicy>> = flow {

        emit(ResourceResult.Loading)

        try {
            emit(ResourceResult.Success(dummyPrivacyPolicy))
        } catch (e: Exception){
            emit(ResourceResult.Error(e))
        }

    }.flowOn(Dispatchers.IO)
}