package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * */
fun main() {
    val sumII = CombinationSumII()
    println(sumII.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).joinToString(", ")) //[[1, 1, 6], [1, 2, 5], [1, 7]]
    println(sumII.combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5).joinToString(", ")) //[[1, 2, 2], [5]]
}

class CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.isEmpty()) {
            return emptyList()
        }
        val result = ArrayList<ArrayList<Int>>()
        candidates.sort()
        getCombinations(candidates, 0, target, ArrayList(), result)
        return result
    }

    private fun getCombinations(candidates: IntArray, index: Int, target: Int, current: ArrayList<Int>, result: ArrayList<ArrayList<Int>>) {
        if (target == 0) {
            result.add(ArrayList(current))
            return
        }
        if (target < 0) {
            return
        }
        for (i in index until candidates.size) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i])
                getCombinations(candidates, i + 1, target - candidates[i], current, result)
                current.removeAt(current.size - 1)
            }
        }
    }
}