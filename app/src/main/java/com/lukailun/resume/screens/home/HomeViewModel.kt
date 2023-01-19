package com.lukailun.resume.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val index by mutableStateOf(0)

    val isPreviousEnabled
        get() = index > 0

    fun next() {

    }
}