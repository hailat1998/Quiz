package com.hd.quiz.uimain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hd.quiz.R

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}


@Composable
fun SubmitScreen(){
     Row(){

     }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeOfQ(selectedType: MutableState<String>){
    var expanded by remember { mutableStateOf(false) }
    val list = listOf<String>("Choice", "True/False" , "Fill in Blanc")
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = false} ) {
     list.forEach{ options ->
         DropdownMenuItem(
             onClick = {
                 selectedType.value = options
                 expanded = false
             }
         , text =  {
             Text(text = options)
         })
     }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Field(selectedField: MutableState<String>){
    var expanded by remember { mutableStateOf(false) }
    val list = listOf<String>("Science", "History" , "Social")
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Category(selectedCategory: MutableState<String>){
    var expanded by remember { mutableStateOf(false) }
    val list = listOf<String>("Student", "Worker" , "Old_person")
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = false} ) {
        list.forEach{ options ->
            DropdownMenuItem(
                onClick = {
                    selectedCategory.value = options
                    expanded = false
                }
                , text =  {
                    Text(text = options)
                })
        }
    }
}



