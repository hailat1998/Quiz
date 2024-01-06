package com.hd.quiz.uimain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel

class QuizActivity : ComponentActivity() {

    private val selected by lazy{
        intent.getStringExtra("selected")
    }
    private val selectedCategory by lazy{
        intent.getStringExtra("selectedCategory")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    companion object {
          private const val CATEGORY = "selectedCategory"
          private const val FIELD_OF_INTEREST = "selected"
        fun newIntent(context: Context, category: String , fieldOfInterest: String) =
            Intent(context, QuizActivity::class.java).apply {
                putExtra(CATEGORY , category)
                putExtra(FIELD_OF_INTEREST , fieldOfInterest)
            }
    }
}


@Composable
fun Home_Content(viewModel: ViewModel, ){
    Scaffold(bottomBar = {
        Icon(Icons.Sharp.Home, contentDescription = null)
    }) {
        LazyColumn(Modifier.padding(paddingValues = it)){

        }
    }
}


