package com.example.denis_jovitus_buberwa_portifolio_app

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size

@Composable
fun FadeInAnimation() {
    // State to control the alpha value
    var isVisible by remember { mutableStateOf(false) }

    // Animate alpha value
    val alpha by animateFloatAsState(targetValue = if (isVisible) 1f else 0f)

    // Trigger the animation (for example, on composition)
    androidx.compose.runtime.LaunchedEffect(Unit) {
        isVisible = true
    }


    // Apply the alpha value to a composable
    Box(
        modifier = Modifier
            .fillMaxSize()
            .alpha(alpha)
            .background(Color.Blue)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFadeInAnimation() {
    FadeInAnimation()
}
