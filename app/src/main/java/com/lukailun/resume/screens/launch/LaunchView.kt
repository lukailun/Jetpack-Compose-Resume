package com.lukailun.resume.screens.launch

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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

    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        val electricPath = Path.letters(context).first
        drawPath(electricPath, Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        LaunchView()
    }
}