package com.example.comida.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class AppCoroutineScope @Inject constructor(context: CoroutineContext) : CoroutineScope {
    override val coroutineContext: CoroutineContext = context + SupervisorJob()
}