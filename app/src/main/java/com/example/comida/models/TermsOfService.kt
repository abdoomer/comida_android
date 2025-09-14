package com.example.comida.models


data class TermsOfService(
    val title: String = "",
    val terms: List<TermItem> = emptyList<TermItem>()
)


data class TermItem(
    val term: String
)