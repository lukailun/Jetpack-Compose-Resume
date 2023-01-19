package com.lukailun.resume.app

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val isLaunching = mutableStateOf(true)

    init {
        viewModelScope.launch {
            delay(3000)
            isLaunching.value = false
        }
    }
}