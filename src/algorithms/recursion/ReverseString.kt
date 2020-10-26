package algorithms.recursion

import java.lang.StringBuilder

fun main() {
    println(reverseStringRecursive("yoyo mastery"))
    println(reverseStringIterative("yoyo mastery"))
}

//Implement a function that reverses a string using iteration...and then recursion!
//reverseString('yoyo mastery') should return: 'yretsam oyoy'
fun reverseStringRecursive(str: String): String {
    if (str.isEmpty()) {
        return ""
    }
    return reverseStringRecursive(str.substring(1)) + str[0]
}

fun reverseStringIterative(str: String): String {
    if (str.isEmpty()) {
        return ""
    }
    val stringBuilder = StringBuilder()
    for (i in str.length - 1 downTo 0) {
        stringBuilder.append(str[i])
    }
    return stringBuilder.toString()
}