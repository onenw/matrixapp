package com.william.matrixapp.data

import org.w3c.dom.Text
enum class QuestionType{
    SINGLE_CHOICE,MULTIPLE_CHOICE,TEXT_INPUT
}

data class SurveyData(
    val text: String,
    val option: List<String> ,
    val type: QuestionType
)
val surveyData = listOf(
    SurveyData ("Do you enjoy using this App?",
        option =  listOf("Yes","No","Maybe"),
        type = QuestionType.SINGLE_CHOICE),
    SurveyData ("Would you  recommend it to others?",
        option = listOf("Definitely  ","Not Sure","No"),
        type = QuestionType.MULTIPLE_CHOICE),
    SurveyData ("How would you rate your experience?",
        option = listOf("Excellent","Good","Fair","Poor"),
        type = QuestionType.TEXT_INPUT),

)
