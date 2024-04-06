package com.norm.mybeautifulloginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val colorCyan = Color(0xFF22E5B9)
val colorPurple = Color(0xFF7823BA)

@Composable
fun GradientBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        colorCyan,
                        colorPurple,
                    )
                )
            )
    ) {
        content()
    }
}