package com.hd.quiz.uimain

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hd.quiz.api.Question
import com.hd.quiz.repo.QuizRepository
import com.hd.quiz.repo.Quizrepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {
          val repository = QuizRepository()
          var _questions: MutableStateFlow<List<Question>>  =  MutableStateFlow(emptyList())
          val questions
              get() = _questions.asStateFlow()
    init{
        viewModelScope.launch {

        }
    }
    suspend fun getQuestions(category: String, field: String) = repository.getQuestions(category, field)
}