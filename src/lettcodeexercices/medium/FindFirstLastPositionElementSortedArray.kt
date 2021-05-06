package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * */
fun main() {
    val find = FindFirstLastPositionElementSortedArray()
    println(find.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).joinToString(", ")) //[3, 4]
    println(find.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).joinToString(", ")) //[-1, -1]
    println(find.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 5).joinToString(", ")) //[-1, -1]
    println(find.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 10).joinToString(", ")) //[-1, -1]
    println(find.searchRange(intArrayOf(), 0).joinToString(", ")) //[-1, -1]
    println(find.searchRange(intArrayOf(2, 2), 2).joinToString(", ")) //[0, 1]
}

class FindFirstLastPositionElementSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if(nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        var start = 0
        var end = nums.size - 1
        val list = ArrayList<Int>()
        list.add(0, 0)
        list.sort()
        list.toTypedArray()
        while (start <= end) {
            val middle = (start + end) / 2
            when {
                nums[middle] == target -> {
                    //same, get indexes
                    list.add(middle)
                    var i = middle + 1
                    while (i <= nums.size - 1 && nums[i] == target) {
                        list.add(i)
                        i++
                    }
                    i = middle - 1
                    while (i >= 0 && nums[i] == target) {
                        list.add(i)
                        i--
                    }
                    list.sort()
                    return intArrayOf(list.first(), list.last())
                }
                nums[middle] > target -> {
                    end = middle - 1
                }
                else -> {
                    start = middle + 1
                }
            }
        }
        return intArrayOf(-1, -1)
    }
}