package com.example.comida.models

data class PrivacyPolicy(
    val title: String = "",
    val policies: List<PolicyItem> = emptyList<PolicyItem>()
)



data class PolicyItem(
    val term: String
)