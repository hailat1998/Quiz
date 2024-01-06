package com.hd.quiz

import android.app.Application
import com.hd.quiz.repo.Quizrepository

class QuizApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Quizrepository.initialize(this)
    }
}