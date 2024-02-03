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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hd.quiz.MainActivity
import com.hd.quiz.R
import com.hd.quiz.api.Question
import com.hd.quiz.list
import com.hd.quiz.ui.theme.QuizTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList

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
fun Home_Content(viewModel: QuizViewModel , selected : String , selectedCategory: String ) {
    val context = LocalContext.current
    val map = mutableMapOf<String, String>()
    val lazy = rememberLazyListState()
    val update by rememberUpdatedState(newValue = lazy)
    val list2: MutableList<Question> = mutableListOf()
    val result = remember {
        mutableStateOf("")
    }
    val updatedResult = rememberUpdatedState(newValue = result)
    LaunchedEffect(true) {
        viewModel.loading.value = true
        list2.addAll(viewModel.getQuestions(selectedCategory, selected).toList())
        println("received those $list2")
        viewModel.loading.value = false
    }
    LaunchedEffect(viewModel.submitted.value) {
        result.value = viewModel.postAnswer(map).toList()[0].body().toString()

        delay(10000)

        viewModel.submitted.value = false
    }
    Scaffold(
        bottomBar = { BottomBar(context = context, viewModel = viewModel) },
    ) {
        if (!viewModel.loading.value || !viewModel.submitted.value) {
            LazyColumn(Modifier.padding(paddingValues = it), state = update) {
                itemsIndexed(list2) { item, index ->
                    TypeQ(question = index, map)
                }
            }
        } else if (!viewModel.loading.value && viewModel.submitted.value) {
          ShowResult(result = updatedResult.value.value, viewModel = viewModel)
        } else {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}


@Composable
fun TypeQ(question: Question, map : MutableMap<String, String>){
    when(question.typeOfQ){
        "T/f" -> TorF(question , map)
        "Choice" -> ChoiceAn(question, map)
        "fill" -> FillAn(question, map)
    }
}

@Composable
fun TorF(question: Question, map : MutableMap<String, String>){
   val ans = remember {
       mutableStateOf("")
   }
    val ansUpdated = rememberUpdatedState(ans)
    map.put(question.id , ansUpdated.value.value)
    Text(text = question.question)
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()){
        Text(text = "True")
        RadioButton(selected = ans.value ==  "true", onClick = { ans.value = "true"})
        Text(text = "False")
        RadioButton(selected = ans.value ==  "False", onClick = { ans.value = "False"})
    }
}

@Composable
fun ChoiceAn(question: Question, map : MutableMap<String, String>){
    val ans = remember {
        mutableStateOf("")
    }
    val ansUpdated = rememberUpdatedState(ans)
    map.put(question.id , ansUpdated.value.value)
    Text(text = question.question)
    Column(Modifier.fillMaxWidth()) {
        Text(text = question.choice!! )
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
fun FillAn(question: Question, map : MutableMap<String, String>){
    val ans = remember {
        mutableStateOf("")
    }
    val ansUpdated = rememberUpdatedState(ans)
    map.put(question.id , ansUpdated.value.value)
    Column(Modifier.fillMaxWidth()) {
        Text(text = question.question)
        OutlinedTextField(value = ans.value, onValueChange = {ans.value = it})
    }
}

@Composable
fun BottomBar(context: Context , viewModel: QuizViewModel){
    BottomAppBar {
        NavigationBarItem(selected = false,
            onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
            icon = { Icons.Filled.Home })
        NavigationBarItem(selected = false,
            onClick = {  viewModel.submitted.value = !viewModel.loading.value },
            icon = { painterResource(id = R.drawable.visibility_fill0_wght400_grad0_opsz24)})
    }
}

@Composable
fun ShowResult(result: String, viewModel: QuizViewModel){
    Box(Modifier.fillMaxSize()
        .clickable { viewModel.submitted.value = !viewModel.submitted.value} ,
        contentAlignment = Alignment.Center){
        Card(
            Modifier
                .padding(8.dp)
                .wrapContentHeight()) {
          Text(text =result , fontSize = 16.sp , fontWeight = FontWeight.Bold )
        }
    }
}






