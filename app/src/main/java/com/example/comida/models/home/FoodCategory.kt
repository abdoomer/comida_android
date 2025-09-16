package com.example.comida.models.home

import com.example.comida.R
import com.example.comida.dummy.foodItems.burgersCategory
import com.example.comida.dummy.foodItems.donutsCategory
import com.example.comida.dummy.foodItems.hotDogCategory
import com.example.comida.dummy.foodItems.pastaCategory
import com.example.comida.dummy.foodItems.pizzaCategory
import com.example.comida.models.FoodItem
import java.util.UUID

data class FoodCategory(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
) {
    fun convertToJSON(): Map<String, Any?> =
        mapOf(
            "id" to id,
            "title" to title,
        )

    fun getFoodCategoryImage(): Int {

        var image: Int = 0
        when(title){
            "Burger" -> {
                image = R.drawable.burger_menu_image
            }
            "Donuts" -> {
                image = R.drawable.donats_menu_image
            }
            "HotDog" -> {
                image = R.drawable.hotdog_menu_image
            }
            "Pasta" -> {
                image = R.drawable.pasta_menu_image
            }
            "Pizza" -> {
                image = R.drawable.pizza_slice_menu_image
            }
        }

        return image
    }

    fun getFoodCategoryItems() : List<FoodItem>{
        var foodItems: List<FoodItem> = emptyList()
        when(title){
            "Burger" -> {
                foodItems = burgersCategory
            }
            "Donuts" -> {
                foodItems = donutsCategory
            }
            "HotDog" -> {
                foodItems = hotDogCategory
            }
            "Pasta" -> {
                foodItems = pastaCategory
            }
            "Pizza" -> {
                foodItems =pizzaCategory
            }
        }

        return foodItems
    }
}


val foodCategories = listOf<FoodCategory>(
    FoodCategory(
        title = "Burger"
    ),
    FoodCategory(
        title = "Donuts"
    ),
    FoodCategory(
        title = "Pizza"
    ),
    FoodCategory(
        title = "HotDog"
    ),
    FoodCategory(
        title = "Pasta"
    ),
)
