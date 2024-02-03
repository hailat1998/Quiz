package com.hd.quiz.uimain

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hd.quiz.api.Question
import com.hd.quiz.list
import com.hd.quiz.repo.QuizRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuizViewModel : ViewModel() {
         private val repository = QuizRepository()
          private var _questions: MutableStateFlow<List<Question>>  =  MutableStateFlow(emptyList())
          val questions
              get() = _questions.asStateFlow()
    val loading = mutableStateOf(false)


    suspend fun getQuestions(category: String, field: String) : Flow<Question> {
       // val question = repository.getQuestions(category , field)
        delay(3000)
        return flow{
           // question.questions.forEach{
            //    emit(it)

          //  }
            list.forEach{
                emit(it)
                Log.e("VIEWMODEL" , "emitted")
            }
        }
    }
}