package com.lukailun.resume.extensions

import androidx.compose.ui.graphics.Path

val Path.Companion.letterM: Path
    get() = Path().apply {
        this.moveTo(193.3F, 1.9F)
        this.cubicTo(181.5F, 9.1F, 166.2F, 42.4F, 143.5F, 110F)
        this.cubicTo(134.2F, 137.5F, 134.2F, 137.5F, 133.5F, 132.6F)
        this.cubicTo(132.3F, 124.9F, 133.7F, 54F, 135.3F, 40F)
        this.cubicTo(136.2F, 32.5F, 136.4F, 26.6F, 135.9F, 25.2F)
        this.cubicTo(134.1F, 20.4F, 117.8F, 13.1F, 105.1F, 11.4F)
        this.cubicTo(100.5F, 10.8F, 99.5F, 11F, 105.1F, 11.4F)
        this.close()
    }