package com.lukailun.resume.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.lukailun.resume.utils.DataManager

@Composable
fun HomeView(
    viewModel: HomeViewModel = HomeViewModel(
        dataManager = DataManager(
            LocalContext.current,
            fileName = "Bio.json",
        ),
    ),
) {
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
                    viewModel.reset()
                }
                Spacer(modifier = Modifier.width(12.dp))
                ToolbarButton(
                    resourceId = R.drawable.toolbar_caret_left,
                    enabled = viewModel.isPreviousEnabled,
                ) {
                    viewModel.previous()
                }
                Spacer(modifier = Modifier.width(12.dp))
                ToolbarButton(
                    resourceId = R.drawable.toolbar_caret_right,
                    enabled = viewModel.isNextEnabled,
                ) {
                    viewModel.next()
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