package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * */
fun main() {
    val twoSumInputSorted = TwoSumInputSorted()
    println(twoSumInputSorted.twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString(", ")) //[1,2]
    println(twoSumInputSorted.twoSum(intArrayOf(2, 3, 4), 6).joinToString(", ")) //[1,3]
    println(twoSumInputSorted.twoSum(intArrayOf(-1, 0), -1).joinToString(", ")) //[1,2]
}

class TwoSumInputSorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val hashmap = HashMap<Int, Int>()
        for (i in numbers.indices) {
            val remain = target - numbers[i]
            if (!hashmap.containsKey(remain)) {
                hashmap[numbers[i]] = i + 1
            } else {
                return intArrayOf(hashmap[remain]!!, i + 1)
            }
        }
        return intArrayOf()
    }
}