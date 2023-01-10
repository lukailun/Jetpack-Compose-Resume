package com.lukailun.resume.screens.launch

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukailun.resume.extensions.handle
import com.lukailun.resume.screens.launch.models.LetterStep
import com.lukailun.resume.screens.launch.models.Letters
import com.lukailun.resume.ui.theme.ResumeTheme
import com.lukailun.resume.utils.DataManager
import java.io.IOException

@Composable
fun LaunchView() {
    val context = LocalContext.current
    val letters = try {
        DataManager(context, "Letters.json").fetchData(Letters::class.java)
    } catch (e: IOException) {
        null
    }
    val mPath = remember { Path() }
    val ePath = remember { Path() }
    val mSteps = mutableListOf<LetterStep>()
    val eSteps = mutableListOf<LetterStep>()
    var mTargetIndex by remember {
        mutableStateOf(0)
    }
    val mCurrentIndex by animateIntAsState(
        targetValue = mTargetIndex,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
    )
    var eTargetIndex by remember {
        mutableStateOf(0)
    }
    val eCurrentIndex by animateIntAsState(
        targetValue = eTargetIndex,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
    )
    var isFilled by remember { mutableStateOf(false) }
    val filledAlpha by animateFloatAsState(
        targetValue = if (isFilled) 1F else 0F,
        animationSpec = tween(durationMillis = 2000, delayMillis = 2000, easing = LinearEasing),
    )

    LaunchedEffect(Unit) {
        letters?.M?.let {
            mTargetIndex = it.size - 1
        }
        letters?.e?.let {
            eTargetIndex = it.size - 1
        }
        isFilled = true
    }

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
                Box {
                    val steps = letters?.M ?: listOf()
                    val modifier = Modifier
                        .size(150.dp)
                        .offset(x = 58.dp)
                    Canvas(
                        modifier = modifier
                    ) {
                        mSteps.add(steps[mCurrentIndex])
                        mSteps.forEach { mPath.handle(it) }
                        drawPath(
                            path = mPath,
                            color = Color.Black,
                            style = Stroke(width = 2.dp.toPx()),
                        )
                    }
                    Canvas(
                        modifier = modifier
                    ) {
                        val path = Path()
                        steps.forEach { path.handle(it) }
                        drawPath(path = path, color = Color.White.copy(filledAlpha))
                    }
                }
                Spacer(modifier = Modifier.weight(1F))
            }
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Box {
                    val steps = letters?.e ?: listOf()
                    val modifier = Modifier
                        .size(150.dp)
                        .offset(y = 26.dp)
                    Canvas(
                        modifier = modifier
                    ) {
                        eSteps.add(steps[eCurrentIndex])
                        eSteps.forEach { ePath.handle(it) }
                        drawPath(
                            path = ePath,
                            color = Color.Black,
                            style = Stroke(width = 2.dp.toPx()),
                        )
                    }
                    Canvas(
                        modifier = modifier
                    ) {
                        val path = Path()
                        steps.forEach { path.handle(it) }
                        drawPath(path = path, color = Color.White.copy(filledAlpha))
                    }
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