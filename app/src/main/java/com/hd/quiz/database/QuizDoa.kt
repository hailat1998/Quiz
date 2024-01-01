package com.hd.quiz.database

import androidx.room.Dao
import androidx.room.Query
import com.hd.quiz.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDoa {
    @Query("SELECT * FROM Question WHERE ( :category)")
    fun getQuestions(category : String) : Flow<List<Question>>
}