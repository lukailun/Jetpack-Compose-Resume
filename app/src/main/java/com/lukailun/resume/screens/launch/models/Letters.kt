package com.lukailun.resume.screens.launch.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Letters(
    @field:Json(name = "M") val M: List<LetterStep>,
    @field:Json(name = "e") val e: List<LetterStep>,
)