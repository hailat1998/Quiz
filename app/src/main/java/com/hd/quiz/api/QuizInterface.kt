package com.hd.quiz.api

import retrofit2.http.GET
import retrofit2.http.Query

interface QuizInterface {
    @GET
    suspend fun getQuestions(@Query("text") category : String, @Query("text") fieldOfInterest: String) : Any
}