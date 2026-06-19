package com.amonteiro.a06_ynov_android.exo

import kotlin.concurrent.thread
import kotlin.random.Random

var v2 : String? = "toto"

fun main() {

    var res = boulangerie(nbSand = 3, nbBaguette = 5)

}

fun boulangerie(nbCroissant : Int = 0, nbBaguette : Int=0, nbSand : Int=0): Double
    = nbCroissant * PRICE_CROISSANT + nbBaguette * PRICE_BAGUETTE + nbSand * PRICE_SANDWITCH
