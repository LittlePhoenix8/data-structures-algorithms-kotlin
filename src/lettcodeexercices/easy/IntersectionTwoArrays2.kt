package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * */
fun main() {
    val intersectionTwoArrays2 = IntersectionTwoArrays2()
    println(intersectionTwoArrays2.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString(",")) //[2, 2]
    println(intersectionTwoArrays2.intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).joinToString(",")) //[4, 9]
    println(intersectionTwoArrays2.intersect(intArrayOf(1), intArrayOf(1)).joinToString(",")) //[1]
    println(intersectionTwoArrays2.intersect(intArrayOf(1), intArrayOf(1, 1)).joinToString(",")) //[1]
    println(intersectionTwoArrays2.intersect(intArrayOf(2, 1), intArrayOf(1, 2)).joinToString(",")) //[1, 2]
    println(intersectionTwoArrays2.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2)).joinToString(",")) //[2]
}

class IntersectionTwoArrays2 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if(nums1.isEmpty() || nums2.isEmpty()) {
            return intArrayOf()
        }
        val map = HashMap<Int, Int>()
        val list = ArrayList<Int>()
        for (i in nums1.indices) {
            if (map.containsKey(nums1[i])) {
                map[nums1[i]] = map[nums1[i]]!! + 1
            } else {
                map[nums1[i]] = 1
            }
        }
        for (i in nums2.indices) {
            if (map.containsKey(nums2[i]) && map[nums2[i]]!! > 0) {
                list.add(nums2[i])
                map[nums2[i]] = map[nums2[i]]!! - 1
            }
        }
        return list.toIntArray()
    }
}