package com.lukailun.resume.models

import java.io.IOException

class FileNotExistException(message: String = "文件不存在。") : IOException(message)

class InvalidJSONException(message: String = "无法将数据转为 JSON。") : IOException(message)