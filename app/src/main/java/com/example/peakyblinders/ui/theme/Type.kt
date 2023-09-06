package com.example.peakyblinders.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.peakyblinders.R

// Set of Material typography styles to start with

val dancingScript = FontFamily(
    Font(R.font.dancing_script_bold, FontWeight.Bold)
)

val lobster = FontFamily(
    Font(R.font.lobster_regular, FontWeight.Normal)
)

val recursive = FontFamily(
    Font(R.font.recursive_regular, FontWeight.Normal),
    Font(R.font.recursive_bold, FontWeight.Bold),
    Font(R.font.recursive_extra_bold, FontWeight.ExtraBold)
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = recursive,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = lobster,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = recursive,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    labelSmall = TextStyle(
        fontFamily = recursive,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.2.sp
    ),
    labelLarge = TextStyle(
        fontFamily = dancingScript,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.2.sp

    )

)