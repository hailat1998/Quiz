package com.hd.quiz.repo

import android.content.Context
import androidx.room.Room
import com.hd.quiz.api.Question
import com.hd.quiz.database.QuizDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow

private const val DATABASE_NAME = "quiz-database"
class Quizrepository private constructor(context: Context , scope: CoroutineScope =GlobalScope) {
    private val database : QuizDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            QuizDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    fun getQuestions(category: String): Flow<List<Question>> = database.QuizDao().getQuestions(category)

    companion object{
        private var INSTANCE : Quizrepository? = null
        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = Quizrepository(context)
            }
        }
        fun get():Quizrepository {
            return INSTANCE ?: throw IllegalStateException("Quizrepository must be initialized")
        }
    }
}