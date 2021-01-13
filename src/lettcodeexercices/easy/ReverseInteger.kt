package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/reverse-integer/
 * */
fun main() {
    val reverseInteger = ReverseInteger()
    println(reverseInteger.reverse(123)) //321
    println(reverseInteger.reverse(-123)) //-321
    println(reverseInteger.reverse(120)) //021
    println(reverseInteger.reverse(0)) //0
}

class ReverseInteger {
    fun reverse(x: Int): Int {
        var num = x
        var result = 0
        while(num != 0) {
            result = (result * 10) + (num % 10)
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0
            }
            num /= 10
        }
        return result
    }
}