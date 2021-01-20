package lettcodeexercices.easy

import java.util.*

/**
 * https://leetcode.com/problems/happy-number/
 * */
fun main() {
    val happyNumber = HappyNumber()
    println(happyNumber.isHappy(19)) //true
    println(happyNumber.isHappy(2)) //false
    println(happyNumber.isHappy(1111111)) //true
}

class HappyNumber {
    fun isHappy(n: Int): Boolean {
        val hashset = HashSet<Int>()
        var squareSum: Int
        var remain: Int
        var number = n
        while (hashset.add(number)) {
            squareSum = 0
            while (number > 0) {
                remain = number % 10
                squareSum += remain * remain
                number /= 10
            }
            if (squareSum == 1) {
                return true
            } else {
                number = squareSum
            }
        }
        return false
    }
}