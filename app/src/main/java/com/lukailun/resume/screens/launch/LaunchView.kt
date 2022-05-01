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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukailun.resume.extensions.letterM
import com.lukailun.resume.ui.theme.ResumeTheme

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
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

//        val trianglePath = Path().let {
//            it.moveTo(this.size.width * .20f, this.size.height * .77f)
//            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
//            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
//            it.close()
//            it
//        }

        val electricPath = Path.letterM

        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height * 0.95f)
        )

//        drawPath(
//            path = trianglePath,
//            Brush.verticalGradient(colors = colors),
//            style = Stroke(width = 15f, cap = StrokeCap.Round)
//        )

        drawPath(path = electricPath, color = Color.White)
    }
}