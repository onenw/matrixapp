package com.william.matrixapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.william.matrixapp.data.QuestionType
import com.william.matrixapp.data.Surveyreponse
import com.william.matrixapp.data.surveyData
import kotlin.time.Duration.Companion.seconds

@Composable
fun SurveyScreen(navController: NavHostController) {
    val totalQuestions = surveyData.size
    var currentIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf("") }

    val currentQuestion = surveyData[currentIndex]
    val response = remember { mutableStateListOf<Surveyreponse>() }


    val progress = (currentIndex + 1).toFloat() / totalQuestions

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Unspecified)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            trackColor= ProgressIndicatorDefaults.linearTrackColor,
            progress = progress,
            modifier = Modifier 
                .fillMaxWidth()
                .height(16.dp)

        )
        Text(
            "Question ${currentIndex + 1} of $totalQuestions",
            style = MaterialTheme.typography.titleLarge
        )


        Spacer(modifier = Modifier.height(16.dp))

        currentQuestion.option.forEach { option: String ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(option)
            }
        }


        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                response.add(
                    Surveyreponse(
                        question = currentQuestion.text,
                        answer = selectedOption
                    )
                )
                if (currentIndex < totalQuestions - 1) {
                      currentIndex++
                    selectedOption = ""

                } else {
                    navController.navigate("thankyou")
                }
            },
            enabled = selectedOption.isNotEmpty()
        ) {
            Text(if (currentIndex == totalQuestions - 1) "Submit" else "Next")
        }

    }

}


