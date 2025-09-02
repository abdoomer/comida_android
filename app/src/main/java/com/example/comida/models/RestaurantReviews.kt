package com.example.comida.models

import java.util.UUID


data class RestaurantReviews(
    val id: String = UUID.randomUUID().toString(),
    val customerReviews: List<CustomerReview> = emptyList<CustomerReview>()
)



data class CustomerReview(
    val id: String = UUID.randomUUID().toString(),
    val customerID: String = "",
    val customerReviewText: String = "",
)