package com.example.comida.models

import androidx.annotation.DrawableRes
import com.example.comida.R


data class AppUser(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    @DrawableRes val profilePicture: Int
)


val dummyUser = AppUser(
    firstName = "John",
    lastName = "Doe",
    username = "user",
    email = "user@email.com",
    profilePicture = R.drawable.profile_picture
)