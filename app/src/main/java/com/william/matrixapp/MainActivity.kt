package com.william.matrixapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.william.matrixapp.ui.theme.MatrixAppTheme
import com.william.matrixapp.ui.theme.screens.SurveyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatrixAppTheme {
                val navController: NavHostController= rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SurveyApp(
                        navController = navController
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Homeprev() {
    SurveyApp(
        modifier = Modifier,
        navController = rememberNavController()
    )
}

