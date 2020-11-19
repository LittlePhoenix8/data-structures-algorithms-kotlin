package lettcodeexercices

fun main() {
    val twoSum = TwoSum()
    println(twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString(",")) //[0, 1]
    println(twoSum.twoSum(intArrayOf(3, 2, 4), 6).joinToString(",")) //[1, 2]
    println(twoSum.twoSum(intArrayOf(3, 3), 6).joinToString(",")) //[0, 1]
    println(twoSum.twoSum(intArrayOf(3, 3), 6).joinToString(",")) //[0, 1]
}

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        val hashmap = HashMap<Int, Int>()
        for (i in nums.indices) {
            val remain = target - nums[i]
            if (hashmap.containsKey(remain)) {
                result[0] = i
                result[1] = hashmap[remain]!!
                return result
            } else {
                hashmap[nums[i]] = i
            }
        }
        return result
    }
}