package com.example.comida.domain.repository

import com.example.comida.domain.dao.SpecialOfferDao
import com.example.comida.domain.usecase.SpecialOffersUseCase
import com.example.comida.models.SpecialOffer
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SpecialOfferRepository @Inject constructor(
    private val specialOffersUseCase: SpecialOffersUseCase
): SpecialOfferDao {
    override fun fetchSpecialOffers(id: String): List<SpecialOffer> {
        TODO("Not yet implemented")
    }

    override fun fetchSpecialOffer(id: String): SpecialOffer {
        TODO("Not yet implemented")
    }
}