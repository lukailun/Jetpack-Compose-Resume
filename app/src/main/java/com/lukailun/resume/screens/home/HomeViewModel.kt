package com.lukailun.resume.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var index by mutableStateOf(0)

    val isPreviousEnabled
        get() = index > 0

    val isNextEnabled
        get() = index < 3

    fun next() {
        if (isNextEnabled) index += 1
    }

    fun previous() {
        if (isPreviousEnabled) index -= 1
    }

    fun reset() {
        index = 0
    }
}