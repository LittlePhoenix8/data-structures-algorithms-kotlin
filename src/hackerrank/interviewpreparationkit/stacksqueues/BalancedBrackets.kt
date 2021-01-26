package hackerrank.interviewpreparationkit.stacksqueues

import java.util.*

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 * */
fun main() {
    val balancedBrackets = BalancedBrackets()
    println(balancedBrackets.isBalanced("{[()]}")) //YES
    println(balancedBrackets.isBalanced("{[(])}")) //NO
    println(balancedBrackets.isBalanced("{{[[(())]]}}")) //YES
    println(balancedBrackets.isBalanced("[{")) //NO
}

class BalancedBrackets {
    fun isBalanced(s: String): String {
        val stack = Stack<Char>()
        for (letter in s) {
            if (letter == '(') {
                stack.push(')')
            } else if (letter == '[') {
                stack.push(']')
            } else if (letter == '{') {
                stack.push('}')
            } else {
                if (stack.isEmpty() || stack.pop() != letter) {
                    return "NO"
                }
            }
        }
        return if (stack.isEmpty()) {
            "YES"
        } else {
            "NO"
        }
    }
}