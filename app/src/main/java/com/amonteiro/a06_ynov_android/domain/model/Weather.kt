package com.amonteiro.a06_ynov_android.domain.model

import kotlinx.serialization.Serializable

//Possible qu'il y ait besoin de cette annotation en fonction du compilateur
@Serializable //KotlinX impose cette annotation
data class Weather(
    val id: Int,
    val name: String,
    val temp: Double,
    val speed: Double,
    val description: String,
    val icon: String,
)