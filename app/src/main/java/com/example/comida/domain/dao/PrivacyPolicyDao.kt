package com.example.comida.domain.dao

import com.example.comida.models.profile.PrivacyPolicy

interface PrivacyPolicyDao {

    fun fetchPrivacyPolicy()

    fun getPrivacyPolicy(): PrivacyPolicy
}