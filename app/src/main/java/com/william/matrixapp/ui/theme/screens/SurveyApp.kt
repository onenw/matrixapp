package com.william.matrixapp.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SurveyApp(modifier: Modifier = Modifier,navController: NavHostController ) {

    NavHost(navController, startDestination = "splash"){
        composable("splash") { SplashScreen(navController) }
        composable ("register"){ RegisterScreen(navController) }
        composable ("login"){ LoginScreen(navController) }
        composable ("home"){ HomeScreen(navController) }
        composable ("survey"){ SurveyScreen(navController)}
        composable ("thank you"){ ThankYouScreen()}
    }
}