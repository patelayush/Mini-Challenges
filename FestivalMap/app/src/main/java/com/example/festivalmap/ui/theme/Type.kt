package com.example.festivalmap.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.festivalmap.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val ParkinsansFontFamily = FontFamily(
    Font(R.font.parkinsansregular, FontWeight.Normal),
    Font(R.font.parkinsansbold, FontWeight.Bold),
    Font(R.font.parkinsanslight, FontWeight.Light),
    Font(R.font.parkinsanssemibold, FontWeight.SemiBold),
    Font(R.font.parkinsansmedium, FontWeight.Medium),
    Font(R.font.parkinsansextrabold, FontWeight.ExtraBold),
    // Add more weights/styles as needed
)