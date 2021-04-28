package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/3sum-closest/
 * */
fun main() {
    val threeSumClosest = ThreeSumClosest()
    println(threeSumClosest.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1)) //2
}

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if(nums.isEmpty() || nums.size < 3) {
            return 0
        }
        nums.sort()
        var max = Int.MAX_VALUE - 1
        var min = Int.MIN_VALUE + 1
        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val threeSum = nums[i] + nums[left] + nums[right]
                when {
                    threeSum == target -> return threeSum
                    threeSum > target -> {
                        max = kotlin.math.min(threeSum, max)
                        right--
                    }
                    else -> {
                        min = kotlin.math.max(threeSum, min)
                        left++
                    }
                }
            }
        }
        return if((max - target) > (target - min)) min else max
    }
}