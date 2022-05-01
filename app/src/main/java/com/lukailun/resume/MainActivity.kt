package com.lukailun.resume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lukailun.resume.screens.launch.messengerIcon
import com.lukailun.resume.screens.launch.models.Letters
import com.lukailun.resume.ui.theme.ResumeTheme
import com.squareup.moshi.Moshi
import java.io.InputStream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readJson()
        setContent {
            ResumeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    messengerIcon()
                }
            }
        }
    }

    private fun readJson() {
        val inputStream = assets.open("Letters.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Letters::class.java)
        val letters = adapter.fromJson(jsonString)
    }
}