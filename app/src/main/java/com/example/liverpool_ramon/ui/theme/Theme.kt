package com.example.liverpool_ramon.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = RojoLiverpool,
    onPrimary = Color.White,
    background = Fondo,
    onBackground = TextoOscuro,
    surface = Color.White,
    onSurface = TextoOscuro
)

@Composable
fun Liverpool_ramonTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
