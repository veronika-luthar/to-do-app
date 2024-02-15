package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
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
                    val AppIcons = Icons.Rounded
                    Header(AppIcons.Delete, AppIcons.Add)
                }
            }
        }
    }
}

@Composable
fun Header(deleteIcon: ImageVector, addIcon: ImageVector, modifier: Modifier = Modifier) {
    val buttonColors = buttonColors(containerColor = Color.Transparent, contentColor = Color.Black)

    // Header
    Row {

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToDoAppTheme {
        val AppIcons = Icons.Rounded
        Header(AppIcons.Delete, AppIcons.Add)
    }
}