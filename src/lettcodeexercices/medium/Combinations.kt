package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/combinations/
 * */
fun main() {
    val combinations = Combinations()
    printList(combinations.combine(4, 2)) //[[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
    printList(combinations.combine(1, 1)) //[[1]]
}

private fun printList(answer: List<List<Int>>) {
    for (ans in answer) {
        print(ans.joinToString(", "))
        print("-")
    }
    println()
}

class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val answer = ArrayList<ArrayList<Int>>()
        if (k > n) {
            return answer
        }
        val current = ArrayList<Int>()
        backtrack(1, current, n, k, answer)
        return answer
    }

    private fun backtrack(start: Int, current: ArrayList<Int>, n: Int, k: Int, answer: ArrayList<ArrayList<Int>>) {
        if (current.size == k) {
            answer.add(ArrayList(current))
            return
        }
        for (i in start..n) {
            current.add(i)
            backtrack(i + 1, current, n, k, answer)
            current.removeAt(current.size - 1)
        }
    }
}