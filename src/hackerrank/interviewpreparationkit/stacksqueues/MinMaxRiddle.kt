package hackerrank.interviewpreparationkit.stacksqueues

import java.util.*

/**
 * https://www.hackerrank.com/challenges/min-max-riddle/problem
 * */
fun main() {
    val minMaxRiddle = MinMaxRiddle()
    println(minMaxRiddle.riddle(arrayOf(6, 3, 5, 1, 12)).joinToString(", ")) //[12, 3, 3, 1, 1]
    println(minMaxRiddle.riddle(arrayOf(2, 6, 1, 12)).joinToString(", ")) //[12, 2, 1, 1]
    println(minMaxRiddle.riddle(arrayOf(1, 2, 3, 5, 1, 13, 3)).joinToString(", ")) //[13, 3, 2, 1, 1, 1, 1]
    println(minMaxRiddle.riddle(arrayOf(3, 5, 4, 7, 6, 2)).joinToString(", ")) //[7, 6, 4, 4, 3, 2]
    //println(minMaxRiddle.riddle(arrayOf()).joinToString(", ")) //[12, 3, 3, 1, 1]
}

class MinMaxRiddle {
    fun riddle(arr: Array<Long>): Array<Long> {
        val stack = Stack<Long>()
        val size = arr.size
        for (i in 1..size) {
        }
        return arrayOf()
    }
}