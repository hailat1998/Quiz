package com.hd.quiz.uimain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.hd.quiz.R
import com.hd.quiz.ui.theme.QuizTheme

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            QuizTheme {
                SubmitScreen()
            }
        }
    }
    companion object{
        fun newIntent(context : Context): Intent {
            return Intent(context, SubmitActivity::class.java)
        }
    }
}

@Composable
fun SubmitScreen(){
    val selectedType = remember { mutableStateOf("Choice") }
    val selectedField = remember { mutableStateOf("Science") }
    val selectedCategory = remember { mutableStateOf("Student") }
    val choice = remember {
        mutableStateOf("")
    }
    val list = remember {
        mutableListOf(mutableStateOf(""))
    }
    val fillT = remember {
        mutableStateOf("")
    }
    val ansTF = remember {
        mutableStateOf("false")
    }
    val fill = remember {
        mutableStateOf("")
    }
    val fillAn = remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item{ TypeOfQ(selectedType = selectedType) }

            item{ Field(selectedField) }

            item{ Category(selectedCategory = selectedCategory) }

        }
        /*
        when (selectedType.value) {
            "Choice" -> Choice(question = choice, list = list)
            "True/False" -> TrF(question = fillT, answer = ansTF)
            else -> Fill(question = fill, answer = fillAn)
        }*/
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeOfQ(selectedType: MutableState<String>){
    var expanded by remember { mutableStateOf(false) }
    val list = listOf<String>("Choice", "True/False" , "Fill in Blanc")
    Box{
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = false} ) {
            list.forEach { options ->
                DropdownMenuItem(
                    onClick = {
                        selectedType.value = options
                        expanded = false
                    }, text = {
                        Text(text = options)
                    })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Field(selectedField: MutableState<String>){
    var expanded by remember { mutableStateOf(false) }
    val list = listOf<String>("Science", "History" , "Social")
    Box{
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = false} ) {
            list.forEach{ options ->
                DropdownMenuItem(
                    onClick = {
                        selectedField.value = options
                        expanded = false
                    }
                    , text =  {
                        Text(text = options)
                    })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Category(selectedCategory: MutableState<String>) {
    var expanded by remember { mutableStateOf(false) }
    val list = listOf<String>("Student", "Worker", "Old_person")
    Box {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = false }) {
            list.forEach { options ->
                DropdownMenuItem(
                    onClick = {
                        selectedCategory.value = options
                        expanded = false
                    }, text = {
                        Text(text = options)
                    })
            }
        }
    }
}



@Composable
fun Choice(question: MutableState<String>, list: MutableList<MutableState<String>>){

    Column {
        Text(text = "Please fill the Question", fontWeight = FontWeight.Bold)
        OutlinedTextField(value = question.value, onValueChange = { question.value = it })
        Text(text = "Fill the choices")
        list.forEach { value ->
            OutlinedTextField(value = value.value, onValueChange = { value.value = it }, label = { Text(
                text = "Option"
            )
            })
        }
        Button(onClick = { list.add(mutableStateOf("")) }) {
            Icons.Sharp.Add
        }
    }
}

@Composable
fun TrF(question: MutableState<String>, answer: MutableState<String>){
    Column {
        OutlinedTextField(value = question.value, onValueChange = { question.value = it })
        Row {
            RadioButton(selected = answer.value == "True", onClick = { answer.value = "True" })
            Text(text = "True",
                Modifier.clickable { answer.value = "True" })
            RadioButton(selected = answer.value == "False", onClick = { answer.value = "False" })
            Text(text = "False",
                Modifier.clickable { answer.value = "False" })
        }
    }
}

@Composable
fun Fill(question: MutableState<String>, answer: MutableState<String>){
    Column {
        OutlinedTextField(value = question.value, onValueChange = { question.value = it })

        OutlinedTextField(value = answer.value, onValueChange = { answer.value = it })
    }
}

