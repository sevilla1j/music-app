package com.jsevilla.musicapp.presentation.util

object StringUtil {
    fun isNullOrEmpty(value: String?): Boolean {
        return value == null || "" == value.trim { it <= ' ' }
    }
}
