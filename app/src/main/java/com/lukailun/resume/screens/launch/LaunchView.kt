package com.lukailun.resume.screens.launch

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukailun.resume.extensions.M
import com.lukailun.resume.screens.launch.models.LetterStep
import com.lukailun.resume.screens.launch.models.LetterStepKey
import com.lukailun.resume.screens.launch.models.Letters
import com.lukailun.resume.ui.theme.ResumeTheme
import com.squareup.moshi.Moshi

@Composable
fun LaunchView() {
    Text(text = "Hello")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        LaunchView()
    }
}

@Composable
fun messengerIcon() {
    val context = LocalContext.current

    Canvas(
        modifier = Modifier
            .size(100.dp)
    ) {
        val electricPath = Path.M(context)
        drawPath(path = electricPath, color = Color.Red)
    }
}