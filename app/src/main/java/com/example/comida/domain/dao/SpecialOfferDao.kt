package com.example.comida.domain.dao

import com.example.comida.models.SpecialOffer


interface SpecialOfferDao {

    fun fetchDummySpecialOffers()

    fun fetchAllSpecialOffers(): List<SpecialOffer>

    fun getSpacialOffer(id: String): SpecialOffer
}