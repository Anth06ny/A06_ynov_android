package com.amonteiro.a06_ynov_android.domain.model

import kotlinx.serialization.Serializable

//Possible qu'il y ait besoin de cette annotation en fonction du compilateur
@Serializable //KotlinX impose cette annotation
data class Weather(
    var id: Int, //id d'un point météo
    var name: String,
    var temp: Double, //Température
    var speed: Double, //Vitesse du vent
    var description: String, //1er description
    var icon: String //1er icone
) {

}