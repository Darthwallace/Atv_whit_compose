package com.example.teste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiplicationTable()
        }
    }
}

@Composable
fun MultiplicationTable() {
    val selectedNumber = remember { mutableStateOf(0) }
    val numberList = remember {
        mutableStateListOf<Int>().apply {
            for (i in 1..10) {
                add(i)
            }
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = selectedNumber.value.toString(),
            onValueChange = {
                selectedNumber.value = it.toIntOrNull() ?: 1
            },
            label = { Text("Digite um número") }
        )
        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        Text(text = "Tabuada do ${selectedNumber.value}:")
        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        for (i in 1..10) {
            val result = selectedNumber.value * i
            Text(text = "${selectedNumber.value} x $i = $result")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MultiplicationTable()
}
