package com.amonteiro.a06_ynov_android.presentation.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amonteiro.a06_ynov_android.presentation.ui.theme.A06_ynov_androidTheme
import com.amonteiro.a06_ynov_android.presentation.viewmodel.MainViewModel

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true,
           uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
@Composable
fun SearchScreenPreview() {
    //Il faut remplacer NomVotreAppliTheme par le thème de votre application
    //Utilisé par exemple dans MainActivity.kt sous setContent {...}
    A06_ynov_androidTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val mainViewModel = MainViewModel()
            mainViewModel.loadFakeData()
            SearchScreen(modifier = Modifier.padding(innerPadding), mainViewModel=  mainViewModel)
        }
    }
}

@Composable
fun SearchScreen(modifier: Modifier = Modifier, mainViewModel: MainViewModel = MainViewModel()) {

    val list = mainViewModel.dataList.collectAsStateWithLifecycle().value

    Column(modifier= modifier) {
        Text(text = "Text1",fontSize = 20.sp)
        Spacer(Modifier.size(8.dp))
        Text(text = "Text2",fontSize = 14.sp,
            modifier = Modifier.padding(10.dp)
            )

        list.forEach {
            PictureRowItem(it.name)
        }
    }
}

@Composable
fun PictureRowItem(text:String) {
    Text(text = text,fontSize = 20.sp)
}