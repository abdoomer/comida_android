package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.SpecialOfferDao
import com.example.comida.domain.usecase.SpecialOffersUseCase
import com.example.comida.models.ResourceResult
import com.example.comida.models.SpecialOffer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SpecialOfferRepository @Inject constructor(
    private val specialOffersUseCase: SpecialOffersUseCase,
    private val appCoroutineScope: AppCoroutineScope
): SpecialOfferDao {

    private val _specialOffers: MutableStateFlow<List<SpecialOffer>> = MutableStateFlow(emptyList())

    init {
        fetchDummySpecialOffers()
    }

    override fun fetchDummySpecialOffers(){
        appCoroutineScope.launch {
            specialOffersUseCase().collect { result ->
                when(result){
                    is ResourceResult.Loading -> {}
                    is ResourceResult.Success -> {
                        _specialOffers.emit(result.data)
                    }
                    is ResourceResult.Error -> {}
                    else -> Unit
                }
            }
        }
    }

    override fun fetchAllSpecialOffers(): List<SpecialOffer> {
        return _specialOffers.value
    }

    override fun getSpacialOffer(id: String): SpecialOffer {
        return _specialOffers.value.first() { it.id == id }
    }
}