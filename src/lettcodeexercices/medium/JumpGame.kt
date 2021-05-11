package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/jump-game/
 * */
fun main() {
    val jumpGame = JumpGame()
    println(jumpGame.canJump(intArrayOf(2, 3, 1, 1, 4))) //true
    println(jumpGame.canJump(intArrayOf(3, 2, 1, 0, 4))) //false
    println(jumpGame.canJump(intArrayOf(0))) //true
    println(jumpGame.canJump(intArrayOf(0, 1))) //false
}

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var lastValidIndex = nums.size - 1
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] + i >= lastValidIndex) {
                lastValidIndex = i
            }
        }
        return lastValidIndex == 0
    }
}