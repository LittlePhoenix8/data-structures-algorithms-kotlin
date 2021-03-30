package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/next-permutation/
 * */
fun main() {
    val nextPermutation = NextPermutation()
    val array1 = intArrayOf(1,3,7,3,2)
    nextPermutation.nextPermutation(array1)
    println(array1.joinToString(", ")) //[1,7,2,3,3]

    val array2 = intArrayOf(1,2,3)
    nextPermutation.nextPermutation(array2)
    println(array2.joinToString(", ")) //[1,3,2]

    val array3 = intArrayOf(3,2,1)
    nextPermutation.nextPermutation(array3)
    println(array3.joinToString(", ")) //[1,2,3]

    val array4 = intArrayOf(1,1,5)
    nextPermutation.nextPermutation(array4)
    println(array4.joinToString(", ")) //[1,5,1]

    val array5 = intArrayOf(1)
    nextPermutation.nextPermutation(array5)
    println(array5.joinToString(", ")) //[1]
}

class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        if (nums.size < 2) {
            return
        }
        var i = nums.size - 1
        //while i - 1 is bigger than current
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--
        }
        //if i is <= 0 order ascending
        if (i <= 0) {
            nums.sort()
            return
        }
        //pivot = nums[i - 1]
        var j = nums.size - 1
        //find item most to the right that is bigget than the pivot
        while (nums[j] <= nums[i - 1]) {
            j--
        }
        //swap = nums[j]
        val temp = nums[i - 1] //pivot
        nums[i - 1] = nums[j] //swap rightmost
        nums[j] = temp

        //reverse suffix from i to nums.size - 1
        j = nums.size - 1
        while (i < j) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
        return
    }
}