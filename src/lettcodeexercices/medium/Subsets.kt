package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/subsets/
 * */
fun main() {
    val subsets = Subsets()
    val subset1 = subsets.subsets(intArrayOf(1, 2, 3))
    printList(subset1)
}

private fun printList(answer: List<List<Int>>) {
    for (ans in answer) {
        print("[")
        print(ans.joinToString(", "))
        print("], ")
    }
    println()
}


class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val subsets = ArrayList<ArrayList<Int>>()
        backtrack(0, nums, ArrayList(), subsets)
        return subsets
    }

    private fun backtrack(index: Int, nums: IntArray, current: ArrayList<Int>, subsets: ArrayList<ArrayList<Int>>) {
        subsets.add(ArrayList(current))
        for (i in index until nums.size) {
            current.add(nums[i])
            backtrack(i + 1, nums, current, subsets)
            current.removeAt(current.size - 1)
        }
    }
}