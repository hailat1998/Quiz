package com.hd.quiz.repo

import com.hd.quiz.api.QuizInterface
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class QuizRepository {
        private var api : QuizInterface
        init {
                val retrofit = Retrofit.Builder()
                               .baseUrl("https://api.flickr.com/")
                               .addConverterFactory(MoshiConverterFactory.create())
                               .build()

                api = retrofit.create()
        }

        suspend fun getQuestions(category : String , fieldOfInterest: String)  = api.getQuestions(category , fieldOfInterest)
}