package com.lukailun.resume.screens.launch.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LetterStepParamsPoint(
    @field:Json(name = "x") val x: Float,
    @field:Json(name = "y") val y: Float,
)