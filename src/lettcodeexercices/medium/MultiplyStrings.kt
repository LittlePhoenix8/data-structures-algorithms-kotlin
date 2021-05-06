package lettcodeexercices.medium

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/multiply-strings/
 * */
fun main() {
    val multiplyStrings = MultiplyStrings()
    println(multiplyStrings.multiply("2", "3")) //6
    println(multiplyStrings.multiply("123", "456")) //56088
}

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        val m = num1.length
        val n = num2.length
        val result = IntArray(m + n)
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val multiply = (num1[i] - '0') * (num2[j] - '0')
                val sum = result[i + j + 1] + multiply
                result[i + j] += sum / 10
                result[i + j + 1] = sum % 10
            }
        }
        val stringBuilder = StringBuilder()
        for (num in result) {
            if (stringBuilder.isNotEmpty() || num != 0) {
                stringBuilder.append(num)
            }
        }
        return if (stringBuilder.isNotEmpty()) stringBuilder.toString() else "0"
    }
}