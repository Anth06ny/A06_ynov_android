package com.amonteiro.a06_ynov_android.exo

fun main() {
    var car = CarEntity(model = "Leon", marque = "Seat")
//    car.color = "Rouge"
//
//    var car2 = CarEntity(model = "Leon", marque = "Seat")
//    var car3 = car
//
//    println(car)
//    println(car2)
//    println(car3)

}

class RandomName() {
    private val list = arrayListOf("Tobby", "bob", "Tommy")
    private var oldName = ""

    fun add(name: String) {
        if (name.isNotBlank() && name !in list) {
            list.add(name)
        }
    }

    fun addAll(vararg names: String) {
        for (name in names) {
            add(name)
        }
    }

    fun next() = list.random()

    fun nextDiff(): String {
        var newValue = next()
        while (newValue == oldName) {
            newValue = next()
        }
        oldName = newValue
        return newValue
    }

    fun nextDiff2(): String {
        oldName = list.filter { it != oldName }.random()
        return oldName
    }

    fun nextDiff3() = list.filter { it != oldName }.random().also { oldName = it }

    fun next2() = Pair(nextDiff(), nextDiff())

}


data class CarEntity(var marque: String = "", var model: String = "") {
    var color = ""

    fun print() = "C'est une $marque $model de $color grise"

    init {
        println("Création d'une voiture")
    }

}