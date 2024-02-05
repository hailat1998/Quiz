package com.hd.quiz.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface QuizInterface {
    @GET("/Quiz")
    suspend fun getQuestions(@Query("category") category : String, @Query("fieldOfInterest") fieldOfInterest: String) : Questions

    @POST("/checkAnswer")
    suspend fun postAnswer(@Body idAndAnPair : MutableMap< String, String>) : String

}