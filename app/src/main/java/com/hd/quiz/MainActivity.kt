package com.hd.quiz

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hd.quiz.ui.theme.QuizTheme
import com.hd.quiz.uimain.QuizActivity
import java.util.Locale.Category

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizTheme {
            Surface {
                Select()
            }

            }
        }
    }
}

@Composable
fun Select(){
    var selected by remember { mutableStateOf("Science") }
    var selectedCategory by remember { mutableStateOf("Student") }
    val context = LocalContext.current
    Column(verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        Text(
            text = "Please Choose your Category and Field Of Interest",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Field Of Interest", fontSize = 12.sp)
        Row {
            RadioButton(selected = selected == "Science" , onClick = { selected = "Science" })
            Text(text = "Science" ,
                Modifier.clickable { selected = "Science" })
            RadioButton(selected = selected == "History" , onClick = { selected = "History" })
            Text(text = "History" ,
                Modifier.clickable { selected = "History" })
            RadioButton(selected = selected == "Social" , onClick = { selected = "Social" })
            Text(text = "Social" ,
                Modifier.clickable { selected = "Social" })
        }
        Text(text = "Category", fontSize = 12.sp)
        Row{
            RadioButton(selected = selectedCategory == "Student" , onClick = { selectedCategory = "Student" })
            Text(text = "Student", modifier = Modifier.clickable { selectedCategory = "Student" })

            RadioButton(selected = selectedCategory == "Worker" , onClick = { selectedCategory = "Worker" })
            Text(text = "Worker", modifier = Modifier.clickable { selectedCategory = "Worker" })

            RadioButton(selected = selectedCategory == "Old_Person" , onClick = { selectedCategory = "Old_Person" })
            Text(text = "Old_Person", modifier = Modifier.clickable { selectedCategory = "Old_Person" })

        }

        Button(onClick = { context.startActivity(QuizActivity.newIntent(context , selectedCategory , selected)) }) {
            Icon(Icons.Filled.ArrowForward , contentDescription = null , Modifier.fillMaxWidth())
        }
    }
}