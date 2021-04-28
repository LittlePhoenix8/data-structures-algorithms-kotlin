package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/4sum/
 * */
fun main(){
    val fourSum = FourSum()
    println(fourSum.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0).joinToString(", ")) //[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    println(fourSum.fourSum(intArrayOf(2, 2, 2, 2, 2), 8).joinToString(", ")) //[[2,2,2,2]]
    println(fourSum.fourSum(intArrayOf(0, 0, 0, 0), 0).joinToString(", ")) //[[0, 0, 0, 0]]
    println(fourSum.fourSum(intArrayOf(-1, 0, 1, 2, -1, -4), -1).joinToString(", ")) //[]
}
class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if(nums.isEmpty() || nums.size < 4) {
            return listOf()
        }
        val result = ArrayList<ArrayList<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 3) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue
            }
            for (j in i + 1 until nums.size - 2) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                var k = j + 1
                var l = nums.size - 1
                while (k < l) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        k++
                        continue
                    }
                    if (l != nums.size - 1 && nums[l] == nums[l + 1]) {
                        l--
                        continue
                    }
                    val fourSum = nums[i] + nums[j] + nums[k] + nums[l]
                    when {
                        fourSum == target -> {
                            result.add(arrayListOf(nums[i], nums[j], nums[k], nums[l]))
                            k++
                        }
                        fourSum < target -> k++
                        else -> l--
                    }
                }
            }
        }
        return result
    }
}