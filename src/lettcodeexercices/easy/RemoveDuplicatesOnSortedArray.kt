package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * */
fun main() {
    val remove = RemoveDuplicatesOnSortedArray()
    println(remove.removeDuplicates(intArrayOf(1,1,2))) //[1, 2] = 2
    println(remove.removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))) //[0,1,2,3,4] = 5
}

class RemoveDuplicatesOnSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var length = 1
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i-1]) {
                nums[length++] = nums[i]
            }
        }
        return length
    }
}