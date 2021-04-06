package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/house-robber/
 * */
fun main() {
    val houseRobber = HouseRobber()
    println(houseRobber.rob(intArrayOf(1,2,3,1))) //4
    println(houseRobber.rob(intArrayOf(2,7,9,3,1))) //12
    println(houseRobber.rob(intArrayOf(2,1,1,2))) //4
}

class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var result = 0
        var prev = 0

        for (num in nums) {
            val tmp = result
            result = kotlin.math.max(prev + num, result)
            prev = tmp
        }
        return result
    }

    fun robRecursive(nums: IntArray): Int {
        return rob(nums, nums.size - 1)
    }

    private fun rob(nums: IntArray, i: Int): Int {
        if (i < 0) {
            return 0
        }
        return kotlin.math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1))
    }
}