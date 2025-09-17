package com.example.comida.domain.dao

import com.example.comida.models.profile.TermsOfService

interface TermsOfServiceDao {

    fun fetchTermsOfService()

    fun getTermsOfService(): TermsOfService
}