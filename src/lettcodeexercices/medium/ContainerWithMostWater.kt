package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/container-with-most-water/
 * */
fun main() {
    val containerWithMostWater = ContainerWithMostWater()
    println(containerWithMostWater.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))) //49
    println(containerWithMostWater.maxArea(intArrayOf(1, 1))) //1
    println(containerWithMostWater.maxArea(intArrayOf(4, 3, 2, 1, 4))) //16
    println(containerWithMostWater.maxArea(intArrayOf(1, 2, 1))) //2
}

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        while(left < right) {
            val w = right - left
            val h = kotlin.math.min(height[left], height[right])
            max = kotlin.math.max(max, w * h)
            if(h == height[left]) {
                left++
            } else {
                right--
            }
        }
        return max
    }
}