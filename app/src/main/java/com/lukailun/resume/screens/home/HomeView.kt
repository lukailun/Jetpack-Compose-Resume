package com.lukailun.resume.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.lukailun.resume.extensions.Pink
import com.lukailun.resume.ui.theme.ResumeTheme

@Composable
fun HomeView() {
    val context = LocalContext.current
    var size by remember { mutableStateOf(Size.Zero) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned { size = it.size.toSize() }
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Blue, Color.Red, Color.Pink,
                    ),
                    start = Offset(x = 0F, y = size.height / 2),
                    end = Offset(x = size.width / 2, y = size.height),
                ),
            ),
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        HomeView()
    }
}