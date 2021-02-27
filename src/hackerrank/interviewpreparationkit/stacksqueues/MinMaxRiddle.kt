package hackerrank.interviewpreparationkit.stacksqueues

import java.util.Stack

/**
 * https://www.hackerrank.com/challenges/min-max-riddle/problem
 * */
fun main() {
    val minMaxRiddle = MinMaxRiddle()
    println(minMaxRiddle.riddle(arrayOf(6, 3, 5, 1, 12)).joinToString(", ")) //[12, 3, 3, 1, 1]
    println(minMaxRiddle.riddle(arrayOf(2, 6, 1, 12)).joinToString(", ")) //[12, 2, 1, 1]
    println(minMaxRiddle.riddle(arrayOf(1, 2, 3, 5, 1, 13, 3)).joinToString(", ")) //[13, 3, 2, 1, 1, 1, 1]
    println(minMaxRiddle.riddle(arrayOf(3, 5, 4, 7, 6, 2)).joinToString(", ")) //[7, 6, 4, 4, 3, 2]
}

class MinMaxRiddle {
    fun riddle(arr: Array<Long>): Array<Long> {
        val stack = Stack<Int>()
        val size = arr.size
        val left = IntArray(size + 1) { -1 }
        val right = IntArray(size + 1) { size }
        for (i in 0 until size) {
            while (stack.isNotEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop()
            }
            if (stack.isNotEmpty()) {
                left[i] = stack.peek()
            }
            stack.push(i)
        }
        while (stack.isNotEmpty()) {
            stack.pop()
        }
        for (i in size - 1 downTo 0) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop()
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek()
            }
            stack.push(i)
        }
        val answer = LongArray(size + 1) { 0 }
        for (i in 0 until size) {
            val len = right[i] - left[i] - 1
            answer[len] = kotlin.math.max(answer[len], arr[i])
        }
        for (i in size - 1 downTo 1) {
            answer[i] = kotlin.math.max(answer[i], answer[i + 1])
        }
        val result = LongArray(size)
        for (i in 1..size) {
            result[i - 1] = answer[i]
        }
        return answer.copyOfRange(1, size + 1).toTypedArray()
    }
}