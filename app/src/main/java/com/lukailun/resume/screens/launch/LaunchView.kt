package com.lukailun.resume.screens.launch

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukailun.resume.extensions.letters
import com.lukailun.resume.ui.theme.ResumeTheme

@Composable
fun LaunchView() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Row(modifier = Modifier.offset(x = 20.dp)) {
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Canvas(
                    modifier = Modifier
                        .size(150.dp)
                        .offset(x = 58.dp)
                ) {
                    val M = Path.letters(context).first
                    drawPath(M, Color.White)
                }
                Spacer(modifier = Modifier.weight(1F))
            }
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Canvas(
                    modifier = Modifier
                        .size(150.dp)
                        .offset(y = 26.dp)
                ) {
                    val e = Path.letters(context).second
                    drawPath(e, Color.White)
                }
                Spacer(modifier = Modifier.weight(1F))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        LaunchView()
    }
}