package com.william.matrixapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.william.matrixapp.ui.theme.darkgreen

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface (modifier = Modifier.fillMaxSize().background(darkgreen)){
     Box()  {}
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Welcome to our farmers  Survey")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {navController.navigate("survey")}) {
                Text("Start Survey")
            }
        }
    }
}
