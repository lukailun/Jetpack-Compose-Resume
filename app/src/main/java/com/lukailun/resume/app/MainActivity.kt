package com.lukailun.resume.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lukailun.resume.screens.home.HomeView
import com.lukailun.resume.screens.launch.LaunchView
import com.lukailun.resume.ui.theme.ResumeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResumeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    AnimatedVisibility(
                        visible = !viewModel.isLaunching.value,
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 2000, easing = LinearEasing
                            ),
                            initialAlpha = 0F,
                        ),
                    ) {
                        HomeView()
                    }
                    AnimatedVisibility(
                        visible = viewModel.isLaunching.value,
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 2000, easing = LinearEasing
                            ),
                            targetAlpha = 0F,
                        ),
                    ) {
                        LaunchView()
                    }
                }
            }
        }
    }
}