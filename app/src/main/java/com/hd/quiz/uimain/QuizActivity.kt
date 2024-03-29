package com.hd.quiz.uimain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    val checkAnswer = mutableMapOf<String, Pair<Boolean, Boolean>>()
    val lazy = rememberLazyListState()
    val update by rememberUpdatedState(newValue = lazy)
    val list2: MutableList<Question> = mutableListOf()
    val count = remember {
        mutableStateOf(0)
    }
    val updatedCount = rememberUpdatedState(newValue = count)
    val result = remember {
        mutableStateOf("")
    }
    val size = remember {
        mutableStateOf(0)
    }
    val updatedResult = rememberUpdatedState(newValue = result)
    LaunchedEffect(true) {
        viewModel.loading.value = true
        list2.addAll(viewModel.getQuestions(selectedCategory, selected).toList())
        size.value = viewModel.size.value
        Log.d("QUIZACTIVITY" , "questions called")
        println("received those $list2")
        viewModel.loading.value = false
        for(i in list2){
            map[i.id] = ""
        }
        for(i in list2){
            checkAnswer[i.id] = Pair(false, false)
        }

    }
    if(viewModel.submitClicked.value) {
        LaunchedEffect(true) {
            viewModel.submitted.value = true
            Log.d("QUIZACTIVITY", "answer called")
            result.value = "You have got ${count.value} out ${size.value}"
            delay(3000)
            viewModel.submitted.value = false
        }
    }
    Scaffold(
        bottomBar = { BottomBar(context = context, viewModel = viewModel) },
        topBar = { Text(
            text = "Quiz",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp),
            color = Color.White,
            ) }
    ) {
        if (!viewModel.loading.value && !viewModel.submitClicked.value) {
            LazyColumn(Modifier.padding(paddingValues = it), state = update) {
                itemsIndexed(list2) { item, index ->
                    TypeQ(question = index, count, map, checkAnswer)
                }
            }
        } else if (!viewModel.loading.value && !viewModel.submitted.value) {
          ShowResult(result = updatedResult.value.value, viewModel = viewModel)
        } else {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}


@Composable
fun TypeQ(question: Question, count : MutableState<Int>, map: MutableMap<String, String>, check : MutableMap<String , Pair<Boolean, Boolean>>){
    when(question.typeOfQ){
        "T/f" -> TorF(question , count, map, check)
        "Choice" -> ChoiceAn(question, count, map, check)
        "fill" -> FillAn(question, count , map, check)
    }
}

@Composable
fun TorF(question: Question, count : MutableState<Int> , map: MutableMap<String, String>, ckeck : MutableMap<String , Pair<Boolean, Boolean>>){
   val ans = remember {
       mutableStateOf(map.getValue(question.id))
   }
    val ansUpdated = rememberUpdatedState(ans.value)
    LaunchedEffect(ans.value){
        checkAnswer(question, ckeck, count, ans)
    }
    Log.i("main" , "count")
    Material3Card(modifier = Modifier
        .padding(10.dp),
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column {
            Text(text = question.question)
            Row(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                RadioButton(selected = ans.value == "true", onClick = { ans.value = "true" })
                Text(text = "True", Modifier.padding(0.dp, 10.dp, 20.dp, 0.dp))
                RadioButton(selected = ans.value == "False", onClick = { ans.value = "False" })
                Text(text = "False", Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
            }
        }
    }
    map[question.id] = ans.value

}

@Composable
fun ChoiceAn(question: Question, count : MutableState<Int> , map: MutableMap<String, String>, ckeck : MutableMap<String , Pair<Boolean, Boolean>>){
    val ans = remember {
        mutableStateOf(map.get(question.id)!!)
    }
    val ansUpdated = rememberUpdatedState(ans.value)
    LaunchedEffect(ans.value){
        checkAnswer(question, ckeck, count, ans)
    }
    Material3Card(modifier = Modifier
        .padding(10.dp),
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
       ){

    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Text(text = question.question)
       Row {
           RadioButton(
               selected = ans.value == question.choice!!,
               onClick = { ans.value = question.choice!! })
           Text(text = question.choice!!, Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
       }
       Row{  //insert each of this into Row
        RadioButton(selected = ans.value == question.choice2!! , onClick = { ans.value = question.choice2!!})
        Text(text = question.choice2!!, Modifier.padding(0.dp , 10.dp, 0.dp , 0.dp))}
        Row {
            RadioButton(
                selected = ans.value == question.choice3!!,
                onClick = { ans.value = question.choice3!! })
            Text(text = question.choice3!!, Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
        }
        Row {
            RadioButton(
                selected = ans.value == question.choice4!!,
                onClick = { ans.value = question.choice4!! })
            Text(text = question.choice4!!, Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
        }
       
    }
    }
    map[question.id] = ans.value!!
}

@Composable
fun FillAn(question: Question, count : MutableState<Int>, map: MutableMap<String, String>, ckeck : MutableMap<String , Pair<Boolean, Boolean>>) {
    val ans = remember {
        mutableStateOf(map.get(question.id)!!)
    }
    val ansUpdated = rememberUpdatedState(ans.value)
    LaunchedEffect(ans.value){
        checkAnswer(question, ckeck, count, ans)
    }
    Material3Card(
        modifier = Modifier
            .padding(10.dp),
        backgroundColor = Color.DarkGray,
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = question.question)
            OutlinedTextField(
                value = ans.value!!,
                onValueChange = { ans.value = it },
                label = { Text(text = "fill here") },
                modifier = Modifier.fillMaxWidth())
        }
    }
    map[question.id] = ans.value!!
}

@Composable
fun BottomBar(context: Context , viewModel: QuizViewModel){
    BottomAppBar {
        NavigationBarItem(selected = false,
            onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = {Text(text = "HOME")})
        NavigationBarItem(selected = false,
            onClick = {  viewModel.submitClicked.value = true },
            icon = { Icon(painterResource(id = R.drawable.visibility_fill0_wght400_grad0_opsz24), contentDescription = null)},
            label = { Text(text = "SEE RESULT")})
    }
}

@Composable
fun ShowResult(result: String, viewModel: QuizViewModel){
    Box(
        Modifier
            .fillMaxSize()
            .clickable { viewModel.submitted.value = !viewModel.submitted.value },
        contentAlignment = Alignment.Center){
        Material3Card(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            backgroundColor = Color.DarkGray,
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp,
        ){
          Text(text =result , fontSize = 25.sp , fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth() )
        }
    }
}


@Composable
fun Material3Card(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium       ,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = elevation,
        shadowElevation = elevation,
        border = border,
        content = content
    )
}

fun checkAnswer(question: Question,  map : MutableMap<String, Pair<Boolean, Boolean>>, count: MutableState<Int>, ans: MutableState<String>){
    if((map[question.id]?.first)!!){
        if((map[question.id]?.second)!! && ans.value != question.answer){
            count.value--
            map[question.id] = map[question.id]?.copy(second = false)!!
        }
    }else{
        if(ans.value == question.answer){
            count.value++
            map[question.id] = map[question.id]?.copy(second = true)!!
            map[question.id] = map[question.id]?.copy(first =  true)!!
        }else{
            map[question.id] = map[question.id]?.copy(second = true)!!
            map[question.id] = map[question.id]?.copy(first =  false)!!
        }
    }
}

@Preview
@Composable
fun SHow(){
    ShowResult(result = "say yes", viewModel = QuizViewModel() )
}







