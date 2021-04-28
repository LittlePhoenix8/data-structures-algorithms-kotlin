package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * */
fun main() {
    val searchRotatedSortedArray = SearchRotatedSortedArray()
    println(searchRotatedSortedArray.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)) //4
    println(searchRotatedSortedArray.search(intArrayOf(4,5,6,7,0,1,2), 3)) //-1
    println(searchRotatedSortedArray.search(intArrayOf(1), 0)) //-1
    println(searchRotatedSortedArray.search(intArrayOf(3, 4, 5, 0, 1, 2, 3), 1)) //4
    println(searchRotatedSortedArray.search(intArrayOf(1, 3), 3)) //1
    println(searchRotatedSortedArray.search(intArrayOf(1, 3, 5), 5)) //2
    println(searchRotatedSortedArray.search(intArrayOf(1, 3, 5), 1)) //0
    println(searchRotatedSortedArray.search(intArrayOf(5, 1, 2, 3, 4), 4)) //4
}

class SearchRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        val hashmap = HashMap<Int, Int>()
        for (i in nums.indices) {
            hashmap[nums[i]] = i
        }
        nums.sort()
        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            val middle = (start + end) / 2
            when {
                target == nums[middle] -> {
                    //same
                    return hashmap[nums[middle]]!!
                }
                target > nums[middle] -> {
                    //right
                    start = middle + 1
                }
                else -> {
                    //left
                    end = middle - 1
                }
            }
        }
        return -1
    }
}