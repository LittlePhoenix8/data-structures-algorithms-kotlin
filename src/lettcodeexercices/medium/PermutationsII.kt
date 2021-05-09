package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/permutations-ii/
 * */
fun main() {
    val permutationsII = PermutationsII()
    println(permutationsII.permuteUnique(intArrayOf(1, 1, 2)).joinToString(", ")) //[ [1, 1, 2], [1, 2, 1], [2, 1, 1] ]
    println(permutationsII.permuteUnique(intArrayOf(1, 2, 3)).joinToString(", ")) //[ [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1] ]
}

class PermutationsII {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (nums.isEmpty()) {
            return emptyList()
        }
        val used = BooleanArray(nums.size)
        val permutations = ArrayList<Int>()
        nums.sort()
        helper(nums, permutations, used, result, 0)
        return result
    }

    private fun helper(nums: IntArray, permutations:ArrayList<Int>, used: BooleanArray, result: ArrayList<ArrayList<Int>>, current: Int) {
        if (current == nums.size) {
            result.add(ArrayList(permutations))
            return
        }
        for (i in nums.indices) {
            if (used[i]) {
                continue
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue
            }
            used[i] = true
            permutations.add(nums[i])
            helper(nums, permutations, used, result, current + 1)
            permutations.removeAt(permutations.size - 1)
            used[i] = false
        }
    }
}