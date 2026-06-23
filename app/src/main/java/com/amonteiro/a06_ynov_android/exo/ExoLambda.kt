package com.amonteiro.a06_ynov_android.exo

import com.amonteiro.a06_ynov_android.data.remote.WindDTO

class MyLiveData<T>(value: T) {

    var value: T = value
        set(newValue) {
            field = newValue
            action(newValue)
        }

    var action: (T) -> Unit = {}
}

fun main() {
    var toto = MyLiveData(WindDTO(5.0))

    toto.action = { println(it) }

    //println(toto.value)

    //toto.value.speed++

}

fun exo1() {

    //Déclaration
    //Déclaration
    val lower: (String) -> Unit = { s: String -> println(s.lowercase()) }
    val lowerV2: (String) -> Unit = { s -> println(s.lowercase()) }
    val lowerV3: (String) -> Unit = { println(it.lowercase()) }
    val lowerV4 = { s: String -> println(s.lowercase()) }

    val hour: (Int) -> Int = { it / 60 }

    val max = { a: Int, b: Int -> Math.max(a, b) }

    var minToMinHour: ((Int?) -> Pair<Int, Int>?)? = { if (it != null) Pair(it / 60, it % 60) else null }


    println(minToMinHour?.invoke(123))
    println(minToMinHour?.invoke(null))
    minToMinHour = null
}