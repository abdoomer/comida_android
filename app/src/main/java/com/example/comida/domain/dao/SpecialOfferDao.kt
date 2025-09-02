package com.example.comida.domain.dao

import com.example.comida.models.SpecialOffer


interface SpecialOfferDao {

    fun fetchSpecialOffers(id: String) : List<SpecialOffer>

    fun fetchSpecialOffer(id: String) : SpecialOffer
}