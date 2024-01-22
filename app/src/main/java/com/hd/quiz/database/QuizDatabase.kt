package com.hd.quiz.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hd.quiz.api.Question


@Database(entities = [Question::class], version = 1)
abstract class QuizDatabase  : RoomDatabase(){
    abstract fun QuizDao(): QuizDoa
}