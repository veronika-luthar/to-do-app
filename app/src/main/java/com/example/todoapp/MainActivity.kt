package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ToDoAppUI(Modifier)
                }
            }
        }
    }
}

@Composable
fun Header(deleteIcon: ImageVector, addIcon: ImageVector, modifier: Modifier = Modifier) {
    val buttonColors = buttonColors(containerColor = Color.Transparent, contentColor = Color.Black)
    // Header
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        // Delete button
        Button(
            onClick = {},
            shape = RectangleShape,
            colors = buttonColors
        ) {
            Icon(
                imageVector = deleteIcon,
                contentDescription = "Trash can symbol"
            )
        }
        // TO-DO text
        Text(
            text = "TO-DO",
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
        // Add button
        Button(
            onClick = {},
            shape = RectangleShape,
            colors = buttonColors
        ) {
            Icon(
                imageVector = addIcon,
                contentDescription = "Plus symbol"
            )
        }

    }
}

@Composable
fun Item(text: String, completed: Boolean, modifier: Modifier = Modifier){
    var checkedChange by remember { mutableStateOf(completed)}
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Text(
            text = text,
            textDecoration = if (checkedChange) {
                TextDecoration.LineThrough
            } else {
                null
            },
            modifier = modifier.padding(5.dp)
        )
        Checkbox(
            checked = checkedChange,
            onCheckedChange = {
                checkedChange = !checkedChange
            },

        )
    }
    Divider(
        thickness = 2.dp,
        color = Color.Black,
        modifier = modifier.fillMaxWidth(4/5f)
    )
}

@Composable
fun List(modifier: Modifier = Modifier){

    // List
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
        ){
        for(i in 1..10){
            Item("Incomplete Item", false, modifier)
        }
    }
}

@Composable
fun ToDoAppUI(modifier: Modifier = Modifier){
    val AppIcons = Icons.Rounded
    Column (
        modifier = modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Header(AppIcons.Delete, AppIcons.Add, modifier)
        Divider(
            thickness = 2.dp,
            color = Color.Black
        )
        List(modifier)
    }
}
@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ToDoAppTheme {
        ToDoAppUI(Modifier)
    }
}