package lettcodeexercices

import java.lang.Integer.max

fun main() {
    val maximumSubarray = MaximumSubarray()
    println(maximumSubarray.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maximumSubarray.maxSubArray(intArrayOf(1)))
    println(maximumSubarray.maxSubArray(intArrayOf(0)))
    println(maximumSubarray.maxSubArray(intArrayOf(-1)))
    println(maximumSubarray.maxSubArray(intArrayOf(-2147483647)))
}

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        //array of 1
        if(nums.size == 1) {
            return nums.first()
        }
        //array of 2+
        var largestSum = 0
        var leftPositive = 0
        for (i in 1 until nums.size) {
            largestSum = max(largestSum, leftPositive + nums[i])
            leftPositive = max(0, leftPositive + nums[i])
        }
        return largestSum
    }
}