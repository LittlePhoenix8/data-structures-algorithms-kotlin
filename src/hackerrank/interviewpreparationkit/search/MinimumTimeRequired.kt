package hackerrank.interviewpreparationkit.search

import java.util.*

/**
 * https://www.hackerrank.com/challenges/minimum-time-required/problem
 * */
fun main() {
    val minimumTimeRequired = MinimumTimeRequired()
    println(minimumTimeRequired.minTime(arrayOf(2, 3, 2), 10)) //8
    println(minimumTimeRequired.minTime(arrayOf(2, 3), 5)) //6
    println(minimumTimeRequired.minTime(arrayOf(1, 3, 4), 10)) //7
    println(minimumTimeRequired.minTime(arrayOf(4, 5, 6), 12)) //20
}

class MinimumTimeRequired {
    fun minTime(machines: Array<Long>, goal: Long): Long {
        if(machines.size == 1) {
           return machines.first() * goal
        }
        //get fastest & lowest
        val n = machines.size.toLong()
        Arrays.sort(machines)
        val fastest = machines.first()
        val slowest = machines.last()
        //get min and max days
        var minDays = ((fastest * goal).toDouble() / n.toDouble()).toLong()
        var maxDays = ((slowest * goal).toDouble() / n.toDouble()).toLong()
        var result: Long = -1
        while (minDays < maxDays) {
            val middle = ((minDays + maxDays) / 2)
            var sum: Long = 0
            for (m in machines) {
                sum += (middle / m)
            }
            if (sum < goal) {
                minDays = middle + 1
            } else {
                result = middle
                maxDays = middle
            }
        }
        return result
    }
}