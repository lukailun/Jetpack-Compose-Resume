package com.lukailun.resume.screens.launch.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class LetterStep(
    @field:Json(name = "key") val keyString: String,
    @field:Json(name = "params") val params: LetterStepParams?,
) {
    val key: LetterStepKey
        get() = LetterStepKey.valueOf(keyString.uppercase(Locale.ROOT))
}