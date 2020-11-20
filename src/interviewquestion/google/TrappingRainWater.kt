package interviewquestion.google

import java.util.*

fun main() {
    val trappingRainWater = TrappingRainWater()
    println(trappingRainWater.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))) //6
    println(trappingRainWater.trap(intArrayOf(4,2,0,3,2,5))) //9
}

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) {
            return 0
        }
        val stack = Stack<Int>()
        var i = 0
        var maxWater = 0
        var maxBotWater: Int
        while (i < height.size) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++)
            } else {
                val bot = stack.pop()
                maxBotWater = if (stack.isEmpty()) {
                    0
                } else {
                    val peek = stack.peek()
                    val heightPeek = height[peek]
                    val heightBot = height[bot]
                    val heightI = height[i]
                    (kotlin.math.min(heightPeek, heightI) - heightBot) * (i - peek - 1)
                }
                maxWater += maxBotWater
            }
        }
        return maxWater
    }
}