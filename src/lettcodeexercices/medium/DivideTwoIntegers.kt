package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/divide-two-integers/
 * */
fun main() {
    val divideTwoIntegers = DivideTwoIntegers()
    println(divideTwoIntegers.divide(10, 3)) //3
    println(divideTwoIntegers.divide(7, -3)) //-2
    println(divideTwoIntegers.divide(0, 1)) //0
    println(divideTwoIntegers.divide(1, 1)) //1
    println(divideTwoIntegers.divide(-1, 1)) //-1
    println(divideTwoIntegers.divide(-2147483648, -1)) //2147483647
    println(divideTwoIntegers.divide(-2147483648, 2)) //-1073741824
    println(divideTwoIntegers.divide(-2147483648, -3)) //715827882
    println(divideTwoIntegers.divide(2147483647, -2147483648)) //0
}

class DivideTwoIntegers {
    fun divide(dividend: Int, divisor: Int): Int {
        if(dividend == 0 || divisor == 0) {
            return 0
        }
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }
        if(dividend == divisor) {
            return 1
        }
        var keepNegative = true
        if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            keepNegative = false
        }
        var pDividend = if (dividend > 0) 0 - dividend else dividend
        val pDivisor = if (divisor > 0) 0 - divisor else divisor
        var count = 0
        while (pDividend <= pDivisor) {
            pDividend -= pDivisor
            count++
        }
        return if (keepNegative && count > 0) {
            0 - count
        } else if (!keepNegative && count < 0) {
            0 - count
        } else {
            count
        }
    }
}