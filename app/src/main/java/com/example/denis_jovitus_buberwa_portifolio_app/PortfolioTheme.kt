package com.example.denis_jovitus_buberwa_portifolio_app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    background = Color.White,
    surface = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC6),
    background = Color.Black,
    surface = Color.Black
)

@Composable
fun PortfolioAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
){
    val color = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = color,
        typography = Typography,
        content = content
    )
}