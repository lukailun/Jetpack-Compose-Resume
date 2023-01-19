package com.lukailun.resume.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lukailun.resume.utils.DataManager
import java.io.IOException

class HomeViewModel(private val dataManager: DataManager) : ViewModel() {
    var index by mutableStateOf(0)
    private var contents = listOf<String>()

    val content: String
        get() {
            if (contents.isEmpty() || index >= contents.size) {
                return ""
            }
            return contents[index]
        }

    val isPreviousEnabled
        get() = index > 0

    val isNextEnabled
        get() = index < contents.size - 1

    init {
        println("HomeViewModelInit")
        fetchContents()
    }

    private fun fetchContents() {
        val contents = try {
            dataManager.fetchData(Array<String>::class.java)
        } catch (e: IOException) {
            null
        }
        contents ?: return
        this.contents = contents.toList()
    }

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