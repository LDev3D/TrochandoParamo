package com.example.trochandoparamo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.trochandoparamo.R

// Set of Material typography styles to start with

val leaguajeGotic = FontFamily(
    Font(R.font.leaguaje_gotic),
    Font(R.font.leguaje_gotic_regular),
    Font(R.font.leguaje_gotic_condensed))
val amatic = FontFamily(
    Font(R.font.amaticbold),
    Font(R.font.amatic_regular)
)
val courguette = FontFamily(
    Font(R.font.courgette_regular)
)
val redaction = FontFamily(
    Font(R.font.redaction_bold),
    Font(R.font.redaction_italic),
    Font(R.font.redaction_regular)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = amatic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = leaguajeGotic,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(
        fontFamily = redaction,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = courguette,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)