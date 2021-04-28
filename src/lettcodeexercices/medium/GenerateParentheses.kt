package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/generate-parentheses/
 * */
fun main() {
    val generateParentheses = GenerateParentheses()
    println(generateParentheses.generateParenthesis(1).joinToString(", ")) //[]
    println(generateParentheses.generateParenthesis(2).joinToString(", ")) //[]
}

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val list = ArrayList<String>()
        backtrack(list, "", 0, 0, n)
        return list
    }

    private fun backtrack(list: ArrayList<String>, current: String, open: Int, close: Int, max: Int) {
        if (current.length == max * 2) {
            list.add(current)
            return
        }
        if (open < max) {
            backtrack(list, "$current(", open + 1, close, max)
        }
        if (close < open) {
            backtrack(list, "$current)", open, close + 1, max)
        }
    }
}