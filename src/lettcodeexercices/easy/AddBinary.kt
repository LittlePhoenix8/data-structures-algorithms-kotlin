package lettcodeexercices.easy

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/add-binary/
 * */
fun main() {
    val addBinary = AddBinary()
    println(addBinary.addBinary("11", "1")) //100
    println(addBinary.addBinary("1010", "1011")) //10101
    println(addBinary.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
            "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"))
}

class AddBinary {
    fun addBinary(a: String, b: String): String {
        val stringBuilder = StringBuilder()
        var first: Int = a.length - 1
        var second: Int = b.length - 1
        var carry = 0
        while (first >= 0 || second >= 0) {
            var sum = carry
            if (second >= 0) {
                sum += b[second--] - '0'
            }
            if (first >= 0) {
                sum += a[first--] - '0'
            }
            stringBuilder.append(sum % 2)
            carry = sum / 2
        }
        if (carry != 0) {
            stringBuilder.append(carry)
        }
        return stringBuilder.reverse().toString()
    }
}