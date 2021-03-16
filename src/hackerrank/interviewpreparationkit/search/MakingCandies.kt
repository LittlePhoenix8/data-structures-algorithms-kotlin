package hackerrank.interviewpreparationkit.search

import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

/**
 * https://www.hackerrank.com/challenges/making-candies/problem
 * */
fun main() {
    val makingCandies = MakingCandies()
    println(makingCandies.minimumPasses(1, 2, 1, 60)) //4
    println(makingCandies.minimumPasses(3, 1, 2, 12)) //3
    println(makingCandies.minimumPasses(1, 1, 6, 45)) //16
}

class MakingCandies {
    fun minimumPasses(m: Long, w: Long, p: Long, n: Long): Long {
        var machines = m
        var workers = w
        var candies: Long = 0
        var passes: Long = 0
        var minPasses = Long.MAX_VALUE
        var pass: Long
        while(candies < n) {
            if (p <= candies) {
                val mw = candies / p + machines + workers
                val half = ceil(mw / 2.0).toLong()
                if (workers < machines) {
                    machines = max(m, half)
                    workers = mw - machines
                } else {
                    workers = max(workers, half)
                    machines = mw - workers
                }
                candies %= p
                pass = 1
            } else {
                pass = max(1, (((p - candies) / machines.toDouble()) / workers).toLong())
            }
            passes += pass
            if (Long.MAX_VALUE / workers < pass * machines) {
                return passes
            }
            candies += pass * machines * workers
            minPasses = min(minPasses, passes + ceil((n - candies).toDouble() / (machines * workers)).toLong())
        }
        return minPasses
    }
}