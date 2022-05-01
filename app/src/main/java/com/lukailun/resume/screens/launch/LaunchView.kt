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
import com.lukailun.resume.extensions.letterM
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
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    val context = LocalContext.current

    fun handle(path: Path, step: LetterStep) {
        when (step.key) {
            LetterStepKey.POINT -> {
                val params = step.params ?: return
                path.moveTo(params.endPoint.x, params.endPoint.y)
            }
            LetterStepKey.CURVE -> {
                val params = step.params ?: return
                val controlPoint1 = params.controlPoint1 ?: return
                val controlPoint2 = params.controlPoint2 ?: return
                path.cubicTo(
                    controlPoint1.x,
                    controlPoint1.y,
                    controlPoint2.x,
                    controlPoint2.y,
                    params.endPoint.x,
                    params.endPoint.y
                )
            }
            LetterStepKey.CURVE -> {
                val params = step.params ?: return
                path.lineTo(
                    params.endPoint.x,
                    params.endPoint.y
                )
            }
            LetterStepKey.CURVE -> path.close()
        }
    }
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

        val inputStream = context.assets.open("Letters.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Letters::class.java)
        val letters = adapter.fromJson(jsonString) ?: return@Canvas
        val electricPath = Path().apply {
            letters.M.forEach {
                handle(this, it)
            }
        }
//        val electricPath = Path.letterM

        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height)
        )

//        drawPath(
//            path = trianglePath,
//            Brush.verticalGradient(colors = colors),
//            style = Stroke(width = 15f, cap = StrokeCap.Round)
//        )

        drawPath(path = electricPath, color = Color.Red)
    }
}