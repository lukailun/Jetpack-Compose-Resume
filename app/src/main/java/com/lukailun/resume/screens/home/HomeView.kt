package com.lukailun.resume.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lukailun.resume.ui.theme.ResumeTheme

@Composable
fun HomeView() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(modifier = Modifier.fillMaxSize(), onClick = {
            println("Click!")
        }) {
            Text(text = "Apple")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        HomeView()
    }
}