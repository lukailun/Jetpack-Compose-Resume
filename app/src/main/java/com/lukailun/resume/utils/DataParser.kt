package com.lukailun.resume.utils

import com.squareup.moshi.Moshi

class DataParser(
    private val jsonString: String
) : DataParserInterface {
    override fun <T> parse(type: Class<T>): T? {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(type)
        return adapter.fromJson(jsonString)
    }
}