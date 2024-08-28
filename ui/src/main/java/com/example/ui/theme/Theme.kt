package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.resources.R


@Composable
fun SearchworkappTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current


    CompositionLocalProvider(
        LocalAppColors provides AppColors(),
        LocalAppFonts provides AppFonts()
    ) {
        if (!view.isInEditMode) {
            val window = (view.context as Activity).window
            window.statusBarColor = Colors.surface.toArgb()
            window.navigationBarColor = Colors.surface.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = LocalAppColors.current.surface)) {
            content()
        }
    }

}

val Colors @Composable get() = LocalAppColors.current
val Fonts @Composable get() = LocalAppFonts.current

private val sfProDisplayFontFamily= FontFamily(
    Font(R.font.sfprodisplay_bold, FontWeight.Bold),
    Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    Font(R.font.sfprodisplay_medium, FontWeight.Medium)
)

val LocalAppColors = staticCompositionLocalOf<AppColors>{
    error("colors error")
}

val LocalAppFonts = staticCompositionLocalOf<AppFonts>{
    error("fonts error")
}

@Immutable
data class AppFonts(
    val title1: TextStyle = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    val title2: TextStyle = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    val title3: TextStyle = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    val title4: TextStyle = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    val text1: TextStyle =TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val buttonText1: TextStyle =TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    val buttonText2: TextStyle = TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    val tabText: TextStyle =TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    val number: TextStyle =TextStyle(
        fontFamily = sfProDisplayFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 7.sp
    )
)



@Immutable
data class AppColors(
    val surface: Color = black,
    val surfaceVariant: Color = grey1,
    val tab: Color = grey4,
    val secondary: Color = blue
)

private val black = Color(0xFF0C0C0C)
private val grey1 = Color(0xFF222325)
private val grey2 = Color(0xFF313234)
private val grey3 = Color(0xFF858688)
private val grey4 = Color(0xFF9F9F9F)
private val grey5 = Color(0xFFDBDBDB)
private val white = Color.White
private val blue = Color(0xFF2B7EFE)
private val darkBlue = Color(0xFF00427D)
private val green = Color(0xFF4CB24E)
private val darkGreen = Color(0xFF015905)
private val red = Color(0xFFFF0000)
private val shadowsColor = Color(0xE60C0C0C)

