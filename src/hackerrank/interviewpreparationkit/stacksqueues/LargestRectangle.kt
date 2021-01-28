package hackerrank.interviewpreparationkit.stacksqueues

import java.util.HashMap
import java.util.Stack

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 * */
fun main() {
    val largestRectangle = LargestRectangle()
    println(largestRectangle.largestRectangle(arrayOf(1, 2, 3, 4, 5))) //9
}

class LargestRectangle {
    fun largestRectangle(height: Array<Int>): Long {
        val current = Stack<Int>()
        val heights = HashMap<Int, Int>()
        var maxRectangle = 0
        if (height.isNotEmpty()) {
            current.push(height[0])
            storeCountOfHeight(heights, height[0], 1)
        }
        for (i in 1 until height.size) {
            var k = current.peek()
            if (k > height[i]) {
                var count = 0
                while (!current.isEmpty() && k > height[i]) {
                    current.pop()
                    count = heights[k]!!
                    if (count * k > maxRectangle) maxRectangle = count * k
                    heights[k] = 0
                    k = if (current.isEmpty()) 0 else current.peek()
                }
                if (k < height[i]) {
                    current.push(height[i])
                    storeCountOfHeight(heights, height[i], count)
                }
            } else if (k < height[i]) {
                current.push(height[i])
            }
            for (uniqueHeight in current) {
                storeCountOfHeight(heights, uniqueHeight, 1)
            }
        }
        for (uniqueHeight in heights.keys) {
            val temp = heights[uniqueHeight]!! * uniqueHeight
            if (temp > maxRectangle) {
                maxRectangle = temp
            }
        }
        return maxRectangle.toLong()
    }

    private fun storeCountOfHeight(heights: MutableMap<Int, Int>, height: Int, count: Int) {
        var newCount = count
        if (heights.containsKey(height)) {
            newCount += heights[height]!!
        }
        heights[height] = newCount
    }
}