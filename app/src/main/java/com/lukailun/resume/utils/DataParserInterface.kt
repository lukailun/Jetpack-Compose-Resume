package com.lukailun.resume.utils

interface DataParserInterface {
    fun <T> parse(type: Class<T>): T?
}