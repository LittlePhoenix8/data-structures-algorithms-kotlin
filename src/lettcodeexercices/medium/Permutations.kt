package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/permutations/
 * */
fun main() {
    val permutations = Permutations()
    println(permutations.permute(intArrayOf(1, 2, 3)).joinToString(", ")) //[ [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1] ]
    println(permutations.permute(intArrayOf(0, 1)).joinToString(", ")) //[ [0, 1], [1, 0] ]
    println(permutations.permute(intArrayOf(1)).joinToString(", ")) //[ [1] ]
}

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (nums.isEmpty()) {
            return emptyList()
        }
        val used = BooleanArray(nums.size)
        val permutations = ArrayList<Int>()
        helper(nums, permutations, used, result)
        return result
    }

    private fun helper(nums: IntArray, permutations:ArrayList<Int>, used: BooleanArray, result: ArrayList<ArrayList<Int>>) {
        if (permutations.size == nums.size) {
            result.add(ArrayList(permutations))
            return
        }
        for (i in nums.indices) {
            if (used[i]) {
                continue
            }
            used[i] = true
            permutations.add(nums[i])
            helper(nums, permutations, used, result)
            permutations.removeAt(permutations.size - 1)
            used[i] = false
        }
    }
}