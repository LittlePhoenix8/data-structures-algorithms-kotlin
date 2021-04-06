package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * */
fun main() {
    println(SumOfTwoIntegers().getSum(1, 2))
}

class SumOfTwoIntegers {
    fun getSum(a: Int, b: Int): Int {
        return a.plus(b)
    }
}