package com.hd.quiz.repo

import com.hd.quiz.api.QuizInterface
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class QuizRepository {
        private var api : QuizInterface
        init {
                val retrofit = Retrofit.Builder()
                               .baseUrl("http://10.4.115.0:5027/api/")
                               .addConverterFactory(MoshiConverterFactory.create())
                    .client(
                        OkHttpClient.Builder()
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .addInterceptor(HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }).build()
                    )
                               .build()

                               api = retrofit.create()
        }

        suspend fun getQuestions(category : String , fieldOfInterest: String)  = api.getQuestions(category , fieldOfInterest)

    suspend fun  postAnswer(map: MutableMap<String, String>): String= api.postAnswer(map)
}