package com.lukailun.resume.extensions

import androidx.compose.ui.graphics.Path
import com.lukailun.resume.screens.launch.models.LetterStep
import com.lukailun.resume.screens.launch.models.LetterStepKey

fun Path.handle(step: LetterStep) {
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
        LetterStepKey.LINE -> {
            val params = step.params ?: return
            lineTo(
                params.endPoint.x, params.endPoint.y
            )
        }
        LetterStepKey.CLOSE -> close()
    }
}