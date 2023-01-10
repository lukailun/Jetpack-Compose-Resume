package com.lukailun.resume.extensions

import android.content.Context
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import com.lukailun.resume.screens.launch.models.LetterStep
import com.lukailun.resume.screens.launch.models.LetterStepKey
import com.lukailun.resume.screens.launch.models.Letters
import com.lukailun.resume.utils.DataManager
import java.io.IOException

fun Path.Companion.letters(context: Context): Pair<Path, Path> {
    val mPath = Path()
    val ePath = Path()
    val manager = DataManager(context, "Letters.json")
    val letters = try {
        manager.fetchData(Letters::class.java)
    } catch (e: IOException) {
        null
    }
    letters?.M?.forEach { mPath.handle(it) }
    letters?.e?.forEach { ePath.handle(it) }
    return Pair(mPath, ePath)
}

fun Path.Companion.offsets(context: Context): Pair<List<Offset>, List<Offset>> {
    val manager = DataManager(context, "Letters.json")
    val letters = try {
        manager.fetchData(Letters::class.java)
    } catch (e: IOException) {
        null
    }
    val mOffsets =
        letters?.M?.mapNotNull { it.params?.endPoint }?.map { Offset(it.x, it.y) } ?: listOf()
    val eOffsets =
        letters?.e?.mapNotNull { it.params?.endPoint }?.map { Offset(it.x, it.y) } ?: listOf()
    return Pair(mOffsets, eOffsets)
}


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