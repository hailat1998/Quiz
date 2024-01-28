package com.hd.quiz.uimain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.hd.quiz.MainActivity
import com.hd.quiz.api.Question
import com.hd.quiz.ui.theme.QuizTheme
import java.nio.file.WatchEvent
import java.util.Locale

class QuizActivity : ComponentActivity() {

    private val selected by lazy{
        intent.getStringExtra("selected")
    }

    private val selectedCategory by lazy{
        intent.getStringExtra("selectedCategory")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContent{
         selected?.let { Log.d("QUIZ", it) }
         selectedCategory?.let { Log.d("QUIZ", it) }
         QuizTheme {
             Home_Content(viewModel = QuizViewModel(), selected!!, selectedCategory!!)
         }
     }
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
fun Home_Content(viewModel: ViewModel, selected : String , selectedCategory: String ){
    val context = LocalContext.current
    val lazy = rememberLazyListState()
    LaunchedEffect(true){
        if(lazy.firstVisibleItemIndex == -1){

        }
    }
    Scaffold(bottomBar = {
        Icon(Icons.Sharp.Home, contentDescription = null, modifier = Modifier
            .padding(150.dp, 10.dp)
            .clickable { context.startActivity(Intent(context, MainActivity::class.java)) })

    }) {
        LazyColumn(Modifier.padding(paddingValues = it), state = lazy){

        }
    }
}


@Composable
fun TypeQ(question: Question){
    when(question.typeOfQ){
        "T/f" -> TorF(question)
        "Choice" -> ChoiceAn(question)
        else -> FillAn(question)
    }
}

@Composable
fun TorF(question: Question){
   val ans = remember {
       mutableStateOf("")
   }
    Text(text = question.question)
    Row(Modifier.padding(8.dp)){
        Text(text = "True")
        RadioButton(selected = ans.value ==  "true", onClick = { ans.value = "true"})
        Text(text = "False")
        RadioButton(selected = ans.value ==  "False", onClick = { ans.value = "False"})
    }
}

@Composable
fun ChoiceAn(question: Question){
    val ans = remember {
        mutableStateOf("")
    }
    Text(text = question.question)
    Column {
        Text(text = question.choice!!, overflow = )
        //insert each of this into Row
        RadioButton(selected = ans.value == question.choice!! , onClick = { ans.value = question.choice!!})
        Text(text = question.choice2!!)
        RadioButton(selected = ans.value == question.choice2!! , onClick = { ans.value = question.choice2!!})
        Text(text = question.choice3!!)
        RadioButton(selected = ans.value == question.choice3!! , onClick = { ans.value = question.choice3!!})
        Text(text = question.choice4!!)
        RadioButton(selected = ans.value == question.choice4!! , onClick = { ans.value = question.choice4!!})
    }
}

@Composable
fun FillAn(question: Question){
    val ans = remember {
        mutableStateOf("")
    }
    Column {
        Text(text = question.question)
        OutlinedTextField(value = ans.value, onValueChange = {ans.value = it})
    }
}





