package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/sort-colors/
 * */
fun main() {
    val sortColors = SortColors()
    val array1 = intArrayOf(2,0,2,1,1,0)
    sortColors.sortColors(array1)
    println(array1.joinToString(", ")) //[0,0,1,1,2,2]

    val array2 = intArrayOf(2,0,1)
    sortColors.sortColors(array2)
    println(array2.joinToString(", ")) //[0,1,2]

    val array3 = intArrayOf(1)
    sortColors.sortColors(array3)
    println(array3.joinToString(", ")) //[1]

    val array4 = intArrayOf(0)
    sortColors.sortColors(array4)
    println(array4.joinToString(", ")) //[0]
}
class SortColors {
    fun sortColors(nums: IntArray) {
        var low = 0
        var mid = 0
        var high = nums.size - 1
        while (mid <= high) {
            when (nums[mid]) {
                0 -> swap(low++, mid++, nums)
                1 -> mid++
                2 -> swap(mid, high--, nums)
            }
        }
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}