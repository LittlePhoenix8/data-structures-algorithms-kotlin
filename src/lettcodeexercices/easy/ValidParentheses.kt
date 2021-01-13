package lettcodeexercices.easy

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/
 * */
fun main() {
    val validParentheses = ValidParentheses()
    println(validParentheses.isValid("()")) //true
    println(validParentheses.isValid("()[]{}")) //true
    println(validParentheses.isValid("(]")) //false
    println(validParentheses.isValid("([)]")) //false
    println(validParentheses.isValid("{[]}")) //true
    println(validParentheses.isValid("([{}])")) //true
}

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (char in s) {
            when (char) {
                '(' -> {
                    stack.push(')')
                }
                '[' -> {
                    stack.push(']')
                }
                '{' -> {
                    stack.push('}')
                }
                else -> {
                    if (stack.isEmpty() || stack.pop() != char) {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}