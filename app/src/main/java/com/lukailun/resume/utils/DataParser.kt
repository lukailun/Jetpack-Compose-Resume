package com.lukailun.resume.utils

import com.squareup.moshi.Moshi
import com.lukailun.resume.models.InvalidJSONException
import java.io.IOException

class DataParser(
    private val jsonString: String
) : DataParserInterface {
    override fun <T> parse(type: Class<T>): T? {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(type)
        return adapter.fromJson(jsonString)
    }
}