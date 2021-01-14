package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * */
fun main() {
    val mergeSortedArrays = MergeSortedArrays()
    val array1 = intArrayOf(1,2,3,0,0,0)
    val m = 3
    val array2 = intArrayOf(2,5,6)
    val n = 3
    mergeSortedArrays.merge(array1, m, array2, n)
    println(array1.joinToString(","))

    val array3 = intArrayOf(0)
    val array4 = intArrayOf(1)
    mergeSortedArrays.merge(array3, 0, array4, 1)
    println(array3.joinToString(","))

    val array5 = intArrayOf(2, 0)
    val array6 = intArrayOf(1)
    mergeSortedArrays.merge(array5, 1, array6, 1)
    println(array5.joinToString(","))
}

class MergeSortedArrays {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (m == 0) {
            for (j in 0 until n) {
                nums1[j] = nums2[j]
            }
        }
        var i = nums1.size - 1
        var j = n - 1
        var k = m - 1
        while (i > -1 && j > -1 && k >= -1) {
            if (k == -1) {
                nums1[i] = nums2[j]
                i--
                j--
            } else if (nums2[j] > nums1[k]) {
                nums1[i] = nums2[j]
                i--
                j--
            } else {
                nums1[i] = nums1[k]
                i--
                k--
            }
        }
    }
}