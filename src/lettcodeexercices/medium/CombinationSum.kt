package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/combination-sum/
 * */
fun main() {
    val combinationSum = CombinationSum()
    println(combinationSum.combinationSum(intArrayOf(2, 3, 6, 7), 7).joinToString(",")) //[[2, 2, 3], [7]]
    println(combinationSum.combinationSum(intArrayOf(2, 3, 5), 8).joinToString(",")) //[[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    println(combinationSum.combinationSum(intArrayOf(2), 1).joinToString(",")) //[]
    println(combinationSum.combinationSum(intArrayOf(1), 1).joinToString(",")) //[[1]]
}

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.isEmpty() || target <= 0) {
            return listOf()
        }
        val answer = ArrayList<ArrayList<Int>>()
        getCombinations(candidates, 0, target, ArrayList(), answer)
        return answer
    }

    private fun getCombinations(candidates: IntArray, position: Int, target: Int, combinations: ArrayList<Int>, answer: ArrayList<ArrayList<Int>>) {
        if (target == 0) {
            answer.add(ArrayList(combinations))
        } else {
            for (i in position until candidates.size) {
                if (candidates[i] <= target) {
                    combinations.add(candidates[i])
                    getCombinations(candidates, i, target - candidates[i], combinations, answer)
                    combinations.removeAt(combinations.size - 1)
                }
            }
        }
    }
}