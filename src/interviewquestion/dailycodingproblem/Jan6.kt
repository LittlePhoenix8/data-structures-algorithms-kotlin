package interviewquestion.dailycodingproblem

/**
 * This problem was asked by Amazon.
 * Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
 * For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
 * Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
 * Do this in O(N) time.
 * */
fun main() {
    println(maxSubArray(intArrayOf(34, -50, 42, 14, -5, 86))) //137
    println(maxSubArray(intArrayOf(-5, -1, -8, -9))) //0
}

fun maxSubArray(nums: IntArray): Int {
    //array of 1
    if(nums.size == 1) {
        return nums.first()
    }
    //array of 2+
    var largestSum = 0
    var leftPositive = 0
    for (i in 1 until nums.size) {
        largestSum = Integer.max(largestSum, leftPositive + nums[i])
        leftPositive = Integer.max(0, leftPositive + nums[i])
    }
    return largestSum
}
