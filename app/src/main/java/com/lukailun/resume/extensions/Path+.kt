package com.lukailun.resume.extensions

import android.content.Context
import androidx.compose.ui.graphics.Path
import com.lukailun.resume.screens.launch.models.LetterStep
import com.lukailun.resume.screens.launch.models.LetterStepKey
import com.lukailun.resume.screens.launch.models.Letters
import com.squareup.moshi.Moshi

fun Path.Companion.M(context: Context): Path {
    return Path().apply {
        val inputStream = context.assets.open("Letters.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Letters::class.java)
        val letters = adapter.fromJson(jsonString) ?: return@apply
        letters.M.forEach { handle(it) }
    }
}


private fun Path.handle(step: LetterStep) {
    when (step.key) {
        LetterStepKey.POINT -> {
            val params = step.params ?: return
            moveTo(params.endPoint.x, params.endPoint.y)
        }
        LetterStepKey.CURVE -> {
            val params = step.params ?: return
            val controlPoint1 = params.controlPoint1 ?: return
            val controlPoint2 = params.controlPoint2 ?: return
            cubicTo(
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
            lineTo(
                params.endPoint.x,
                params.endPoint.y
            )
        }
        LetterStepKey.CURVE -> close()
    }
}