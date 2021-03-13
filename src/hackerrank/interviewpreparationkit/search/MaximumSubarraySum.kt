package hackerrank.interviewpreparationkit.search

import java.util.*
import kotlin.math.max

/**
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 * */
fun main() {
    val maximumSubarraySum = MaximumSubarraySum()
    println(maximumSubarraySum.maximumSum2(arrayOf(1, 2, 3), 2))//1
    println(maximumSubarraySum.maximumSum2(arrayOf(3, 3, 9, 9, 5), 7))//6
    println(maximumSubarraySum.maximumSum2(arrayOf(1, 5, 9), 5))//4
}

class MaximumSubarraySum {
    //O(n^2)
    fun maximumSum(a: Array<Long>, m: Long): Long {
        val n = a.size
        var maxSum: Long = Long.MIN_VALUE
        for (left in a.indices) {
            var runningSum: Long = 0
            for (right in left until n) {
                runningSum += a[right]
                val module = runningSum % m
                maxSum = max(maxSum, module)
            }
        }
        return maxSum
    }

    fun maximumSum2(a: Array<Long>, m: Long): Long {
        val n = a.size
        if (n == 0) {
            return 0
        }
        var maxSum: Long = 0
        var currentSum: Long = 0
        val prefix = TreeSet<Long>()
        for (i in 0 until n) {
            currentSum = (currentSum + a[i] % m) % m
            val set = prefix.tailSet(currentSum + 1)
            val iterator = set.iterator()
            if (iterator.hasNext()) {
                maxSum = max(maxSum, (currentSum - iterator.next() + m) % m)
            }
            maxSum = max(maxSum, currentSum)
            prefix.add(currentSum)
        }
        return maxSum
    }
}