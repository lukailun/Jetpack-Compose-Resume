package com.lukailun.resume.screens.launch.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LetterStepParams(
    @field:Json(name = "endPoint") val endPoint: LetterStepParamsPoint,
    @field:Json(name = "controlPoint1") val controlPoint1: LetterStepParamsPoint?,
    @field:Json(name = "controlPoint2") val controlPoint2: LetterStepParamsPoint?,
)