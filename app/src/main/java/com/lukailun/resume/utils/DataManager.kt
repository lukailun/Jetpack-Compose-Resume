package com.lukailun.resume.utils

import android.content.Context
import com.lukailun.resume.models.FileNotExistException
import com.lukailun.resume.models.InvalidJSONException
import java.io.IOException

class DataManager(
    private val context: Context,
    private val fileName: String,
) {
    @Throws(IOException::class)
    fun <T> fetchData(type: Class<T>): T? {
        val inputStream = try {
            context.assets.open(fileName)
        } catch (e: IOException) {
            throw FileNotExistException()
        }
        val jsonString = inputStream.bufferedReader().readText()
        val parser = try {
            DataParser(jsonString)
        } catch (e: IOException) {
            throw InvalidJSONException()
        }
        return parser.parse(type)
    }
}