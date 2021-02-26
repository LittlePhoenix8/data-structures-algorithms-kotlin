package hackerrank.interviewpreparationkit.dynamicprogramming

/**
 * https://www.hackerrank.com/challenges/max-array-sum/problem
 * */
fun main() {
    val maxArraySum = MaxArraySum()
    println("${maxArraySum.maxSubsetSum(arrayOf(-2, 1, 3, -4, 5))}, 8")
    println("${maxArraySum.maxSubsetSum(arrayOf(-2, -3, -1))}, 0")
    println("${maxArraySum.maxSubsetSum(arrayOf(3, 7, 4, 6, 5))}, 13")
    println("${maxArraySum.maxSubsetSum(arrayOf(2, 1, 5, 8, 4))}, 11")
    println("${maxArraySum.maxSubsetSum(arrayOf(3, 5, -7, 8, 10))}, 15")
}

class MaxArraySum {
    fun maxSubsetSum(arr: Array<Int>): Int {
        if (arr.isEmpty()) {
            return 0
        }
        if (arr.size == 1) {
            return arr.first()
        }
        val dp = Array(arr.size) { 0 }
        dp[0] = kotlin.math.max(0, arr[0])
        dp[1] = kotlin.math.max(dp[0], arr[1])
        for (i in 2 until arr.size) {
            dp[i] = kotlin.math.max(dp[i - 1], arr[i] + dp[i - 2])
        }
        if (dp.last() < 0) {
            return 0
        }
        return dp.last()
    }
}