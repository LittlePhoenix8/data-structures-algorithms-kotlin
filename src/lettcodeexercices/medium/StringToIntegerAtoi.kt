package lettcodeexercices.medium

import java.lang.Exception
/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * */
fun main() {
    val stringToIntegerAtoi = StringToIntegerAtoi()
    println(stringToIntegerAtoi.myAtoi("42")) //42
    println(stringToIntegerAtoi.myAtoi("-42")) //-42
    println(stringToIntegerAtoi.myAtoi("4193 with words")) //4193
    println(stringToIntegerAtoi.myAtoi("words and 987")) //0
    println(stringToIntegerAtoi.myAtoi("-91283472332")) //-2147483648
    println(stringToIntegerAtoi.myAtoi("3.14159")) //3
    println(stringToIntegerAtoi.myAtoi("00123")) //123
    println(stringToIntegerAtoi.myAtoi("+-12")) //0
    println(stringToIntegerAtoi.myAtoi("+")) //0
    println(stringToIntegerAtoi.myAtoi("21474836460")) //2147483647
}

class StringToIntegerAtoi {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val stringBuilder = StringBuilder()
        var isNegative = false
        var hasOperator = false
        for (c in s) {
            if (c == ' ') {
                if (stringBuilder.isNotEmpty() || hasOperator) {
                    break
                }
                continue
            } else if (c == '-') {
                if (hasOperator) {
                    if (stringBuilder.isEmpty()) {
                        return 0
                    } else {
                        break
                    }
                }
                isNegative = true
                hasOperator = true
                continue
            } else if (c == '+') {
                if (hasOperator) {
                    if (stringBuilder.isEmpty()) {
                        return 0
                    } else {
                        break
                    }
                }
                isNegative = false
                hasOperator = true
                continue
            } else if (c.isDigit()) {
                stringBuilder.append(c)
                hasOperator = true
                continue
            } else {
                if (stringBuilder.isEmpty()) {
                    return 0
                } else {
                    break
                }
            }
        }
        val n = stringBuilder.toString()
        if (n.isEmpty()) {
            return 0
        }
        val number: Int
        try {
            number = n.toInt()
        } catch (e: Exception) {
            return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
        }
        return if (isNegative) number * -1 else number
    }
}