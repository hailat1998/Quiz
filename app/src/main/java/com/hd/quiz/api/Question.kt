package com.hd.quiz.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Question(
    val id: String,
    val typeOfQ : String,
    val question: String,
    val choice: String?,
    val choice2: String?,
    val choice3: String?,
    val choice4: String?,
    val category: String
    )