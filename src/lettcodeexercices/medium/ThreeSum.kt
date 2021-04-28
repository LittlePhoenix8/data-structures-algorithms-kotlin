package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/3sum/
 * */
fun main() {
    val threeSum = ThreeSum()
    println(threeSum.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).joinToString(", ")) //[[-1,-1,2],[-1,0,1]]
    println(threeSum.threeSum(intArrayOf()).joinToString(", ")) //[]
    println(threeSum.threeSum(intArrayOf(0)).joinToString(", ")) //[]
}

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty() || nums.size < 3) {
            return listOf()
        }
        val result = ArrayList<ArrayList<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val threeSum = nums[i] + nums[left] + nums[right]
                when {
                    threeSum > 0 -> right--
                    threeSum < 0 -> left++
                    else -> {
                        result.add(arrayListOf(nums[i], nums[left], nums[right]))
                        left++
                        while (nums[left] == nums[left - 1] && left < right) {
                            left++
                        }
                    }
                }
            }
        }
        return result
    }
}