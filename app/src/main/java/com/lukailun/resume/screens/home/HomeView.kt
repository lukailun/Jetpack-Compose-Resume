package com.lukailun.resume.screens.home

import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.lukailun.resume.R
import com.lukailun.resume.extensions.Pink
import com.lukailun.resume.ui.theme.ResumeTheme

@Composable
fun HomeView() {
    val context = LocalContext.current
    var size by remember { mutableStateOf(Size.Zero) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned { size = it.size.toSize() }
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Blue, Color.Red, Color.Pink,
                    ),
                    start = Offset(x = 0F, y = size.height / 2),
                    end = Offset(x = size.width / 2, y = size.height),
                ),
            ),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1F))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.me),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.width(200.dp),
                )
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(1F))
            Row {
                Spacer(modifier = Modifier.weight(1F))
                ToolbarButton(resourceId = R.drawable.toolbar_arrow_clockwise) {
                    println("Refresh")
                }
                Spacer(modifier = Modifier.width(12.dp))
                ToolbarButton(resourceId = R.drawable.toolbar_caret_left, enabled = false) {
                    println("Preview")
                }
                Spacer(modifier = Modifier.width(12.dp))
                ToolbarButton(resourceId = R.drawable.toolbar_caret_right) {
                    println("Next")
                }
                Spacer(modifier = Modifier.width(12.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun ToolbarButton(
    @DrawableRes resourceId: Int,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick, enabled = enabled) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(30.dp)
                .alpha(if (enabled) 1F else 0.5F),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        HomeView()
    }
}