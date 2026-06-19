package com.amonteiro.a06_ynov_android.data.remote

import android.R.attr.description
import com.amonteiro.a06_ynov_android.domain.model.Weather
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

//Suspend sera expliqué dans le chapitre des coroutines
suspend fun main() {

    val weathers = WeatherApiDataSource.loadWeathers("toulouse")
    println(weathers)


//    val list : List<MuseumDTO> = KtorMuseumApi.loadMuseums()
//    println(list.joinToString(separator = "\n\n"))
//    KtorMuseumApi.close()
}

object WeatherApiDataSource {
    private const val API_URL =
        "https://www.amonteiro.fr/api/weather?cityname=toulouse"

    //Création et réglage du client
    private val client  = HttpClient {
        install(Logging) {
            //(import io.ktor.client.plugins.logging.Logger)
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.INFO  // TRACE, HEADERS, BODY, etc.
        }
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
        }
        //engine { proxy = ProxyBuilder.http("monproxy:1234") }
    }

    suspend fun loadWeathers(cityName : String): List<Weather> {
        val response = client.get(API_URL)
        if (!response.status.isSuccess()) {
            throw Exception("Erreur API: ${response.status} - ${response.bodyAsText()}")
        }

        var list =  response.body<List<Weather>>()

        //Si je devais faire un Wrapper
        val listSortie = ArrayList<Weather>()
        for(w in list ){
            listSortie.add(Weather(
                id = w.id,
                name = w.name,
                temp = w.temp,
                description = w.description,
                speed = w.speed,
                icon =  w.icon
            ))
        }

        return listSortie
    }
}

/* -------------------------------- */
// DTO
/* -------------------------------- */


