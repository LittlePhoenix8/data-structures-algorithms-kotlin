package lettcodeexercices.medium

import kotlin.math.max

/**
 * https://leetcode.com/problems/jump-game-ii/
 * */
fun main() {
    val jumpGameII = JumpGameII()
    println(jumpGameII.jump(intArrayOf(2, 3, 1, 1, 4))) //2
    println(jumpGameII.jump(intArrayOf(2, 3, 0, 1, 4))) //2
    println(jumpGameII.jump(intArrayOf(0))) //0
    println(jumpGameII.jump(intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0))) //3
}

class JumpGameII {
    fun jump(nums: IntArray): Int {
        val n = nums.size
        var jumps = 1
        if (n == 1 || nums[0] == 0) {
            return 0
        }
        var farthest = nums[0]
        var currentEnd = nums[0]
        for (i in 1 until n) {
            if (i == n - 1) {
                return jumps
            }
            farthest = max(farthest, nums[i] + i)
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest
            }
        }
        return jumps
    }
}