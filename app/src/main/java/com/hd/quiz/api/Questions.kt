package com.hd.quiz.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Questions(@Json(name = "question") val questions : List<Question>)