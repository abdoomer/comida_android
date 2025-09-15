package com.example.comida.models.profile


data class TermsOfService(
    val title: String = "",
    val terms: List<TermItem> = emptyList<TermItem>()
)


data class TermItem(
    val term: String
)