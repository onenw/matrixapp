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
    SurveyData ("What type of farming do you practice?",
        option =  listOf("Crop farming","Livestock farming","Mixed farming","Others"),
        type = QuestionType.SINGLE_CHOICE),
    SurveyData ("What is the size of your farm?",
        option = listOf("Less than 1 acre","1-5 acres","5-10 acres","Over 10 acres"),
        type = QuestionType.MULTIPLE_CHOICE),
    SurveyData ("Which crops do you grow most frequently?",
        option = listOf("maize","Beans","Rice","Vegetables","Fruits","Others"),
        type = QuestionType.TEXT_INPUT),
    SurveyData ("Do you use modern farming techniques?",
        option = listOf("Yes","No","Partially"),
        type = QuestionType.TEXT_INPUT),
    SurveyData ("Where do you sell your farm products?",
        option = listOf("Local markets","Middlemen","Cooperative","Export","Others"),
        type = QuestionType.TEXT_INPUT),
    SurveyData ("What challenges do you face in farming?",
        option = listOf("Lack of capital","Pests & diseases",
            "Unreliable markets","Poor infrastructure","Climate changes","Others"),
        type = QuestionType.TEXT_INPUT),



)
