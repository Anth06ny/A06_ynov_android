package com.amonteiro.a06_ynov_android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amonteiro.a06_ynov_android.data.remote.WeatherApiDataSource
import com.amonteiro.a06_ynov_android.domain.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


suspend fun main(){
    val viewModel = MainViewModel()
    viewModel.loadWeathers("Nice")

    while(viewModel.runInProgress.value) {
        println("Attente....")
        delay(500)
    }

    //Affichage de la liste (qui doit être remplie) contenue dans la donnée observable
    println("List : ${viewModel.dataList.value}" )
    println("runInprogress : ${viewModel.runInProgress.value}" )

}

class MainViewModel : ViewModel() {
    //MutableStateFlow est une donnée observable
    val dataList = MutableStateFlow(emptyList<Weather>())
    val runInProgress = MutableStateFlow(false)


    fun loadWeathers(cityName:String){
        runInProgress.value = true

        viewModelScope.launch(Dispatchers.IO) {
            dataList.value = WeatherApiDataSource.loadWeathers(cityName)
            runInProgress.value = false
        }
    }
}