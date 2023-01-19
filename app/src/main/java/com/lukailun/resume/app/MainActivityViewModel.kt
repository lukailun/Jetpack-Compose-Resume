package com.lukailun.resume.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var isLaunching by mutableStateOf(true)

    init {
        viewModelScope.launch {
            delay(3000)
            isLaunching = false
        }
    }
}