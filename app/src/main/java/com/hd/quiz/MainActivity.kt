package com.hd.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hd.quiz.ui.theme.QuizTheme
import com.hd.quiz.uimain.QuizActivity

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
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
        Text(
            text = "Please Choose your Category and Field Of Interest",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(text = "Field Of Interest", fontSize = 18.sp)
        Row(Modifier.padding(10.dp)) {
            RadioButton(selected = selected == "Science" , onClick = { selected = "Science" })
            Text(text = "Science" ,
                Modifier.clickable { selected = "Science" }.padding(0.dp, 10.dp, 0.dp, 0.dp))
            RadioButton(selected = selected == "History" , onClick = { selected = "History" })
            Text(text = "History" ,
                Modifier.clickable { selected = "History" }.padding(0.dp, 10.dp, 0.dp, 0.dp))
            RadioButton(selected = selected == "Social" , onClick = { selected = "Social" })
            Text(text = "Social" ,
                Modifier.clickable { selected = "Social" }.padding(0.dp, 10.dp, 0.dp, 0.dp))
        }
        Text(text = "Category", fontSize = 18.sp)
        Row(Modifier.padding(10.dp)){
            RadioButton(selected = selectedCategory == "Student" , onClick = { selectedCategory = "Student" })
            Text(text = "Student", modifier = Modifier.clickable { selectedCategory = "Student" }.padding(0.dp, 10.dp, 0.dp, 0.dp))

            RadioButton(selected = selectedCategory == "Worker" , onClick = { selectedCategory = "Worker" })
            Text(text = "Worker", modifier = Modifier.clickable { selectedCategory = "Worker" }.padding(0.dp, 10.dp, 0.dp, 0.dp))

            RadioButton(selected = selectedCategory == "Adult" , onClick = { selectedCategory = "Adult" })
            Text(text = "Adult", modifier = Modifier.clickable { selectedCategory = "Adult" }.padding(0.dp, 10.dp, 0.dp, 0.dp))

        }

        Button(onClick = { context.startActivity(QuizActivity.newIntent(context , selectedCategory , selected)) }) {
            Icon(Icons.Filled.ArrowForward , contentDescription = null , Modifier.fillMaxWidth())
        }

            Spacer(modifier = Modifier.height(10.dp))
            Divider(thickness = 8.dp)
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Or",
                color = Color.LightGray,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center )

        Button(onClick = { /*context.startActivity(SubmitActivity.newIntent(context))*/ },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(
                text = "Submit question",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
