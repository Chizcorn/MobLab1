package com.example.businesscard.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColorScheme(
    primary = Color(0xFFF32121),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF0081FF),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF7CD7FF),
    onSecondary = Color.White,
    surface = Color.White,
    onSurface = Color(0xFF212121),
    surfaceVariant = Color(0xFFF5F5F5),
    onSurfaceVariant = Color(0xFF757575),
    background = Color(0xFFF5F5F5),
    onBackground = Color(0xFF212121),
    outline = Color(0xFFE0E0E0)
)

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFF90CAF9),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF2196F3),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF81D4FA),
    onSecondary = Color.Black,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF2D2D2D),
    onSurfaceVariant = Color(0xFFCCCCCC),
    background = Color(0xFF121212),
    onBackground = Color.White,
    outline = Color(0xFF424242)
)

@Composable
fun BusinessCardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}