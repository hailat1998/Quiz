package com.hd.quiz.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface QuizInterface {
    @GET("/questions")
    suspend fun getQuestions(@Query("text") category : String, @Query("text") fieldOfInterest: String) : Questions

    @POST("/checkAnswer")
    suspend fun postAnswer(@Body idAndAnPair : MutableMap< String, String>) : Flow<Response<String>>

}