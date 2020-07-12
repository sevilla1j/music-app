package com.jsevilla.musicapp.presentation.util

import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

object StringUtil {

    const val Empty = ""

    fun isNullOrEmpty(value: String?): Boolean {
        return value == null || "" == value.trim { it <= ' ' }
    }

    fun isNullOrEmpty(value: Any?): Boolean {
        return value == null || "" == value
    }

    fun StringOrNull(str: Any?): String {
        return str?.toString() ?: ""
    }

    fun StringOrNull(str: Any?, defaulValue: String): String {
        return str?.toString() ?: defaulValue
    }

    fun capitalize(s: String?): String? {
        return if (s == null || s.isEmpty()) s else {
            val phrase = StringBuilder()
            var next = true
            for (c in s.toCharArray()) {
                if (next && Character.isLetter(c) || Character.isWhitespace(c)) next =
                    Character.isWhitespace(
                        Character.toUpperCase(c).also { it }
                    )
                phrase.append(c)
            }
            phrase.toString()
        }
    }

    fun toString(`object`: Any): String {
        if (!`object`.javaClass.isArray) {
            return `object`.toString()
        }
        if (`object` is BooleanArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is ByteArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is CharArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is ShortArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is IntArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is LongArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is FloatArray) {
            return Arrays.toString(`object`)
        }
        if (`object` is DoubleArray) {
            return Arrays.toString(`object`)
        }
        return if (`object` is Array<*>) {
            Arrays.deepToString(`object` as Array<Any?>)
        } else "No se encontro el tipo para el objeto"
    }

    fun getTwoFirstInitials(name: String?): String {
        val p: Pattern = Pattern.compile("((^| )[A-Za-z])")
        val m: Matcher = p.matcher(name)
        var inititals = ""
        while (m.find()) {
            inititals += m.group().trim()
        }
        if (inititals.length > 2) {
            inititals = inititals.substring(0, 2)
        }
        return inititals.toUpperCase()
    }

    fun removePrefix(source: String, prefix: String): String {
        var source = source
        if (source.startsWith(prefix)) source = source.substring(prefix.length)
        return source
    }

    fun subString(source: String, init: Int, max: Int): String {
        var source = source
        if (source.length > max) source = source.substring(init, max) + "..."
        return source
    }

    fun getEmojiByUnicode(unicode: Int): String {
        return String(Character.toChars(unicode))
    }
}
