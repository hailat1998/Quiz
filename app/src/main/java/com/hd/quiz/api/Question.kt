package com.hd.quiz.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Question(
    val id: String,
    val typeOfQ : String,
    val question: String,
    val choice: String? = null,
    val choice2: String? = null,
    val choice3: String? = null,
    val choice4: String? = null,
    val category: String,
    val fieldOfInterest: String
    )