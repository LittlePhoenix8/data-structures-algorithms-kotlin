package hackerrank.interviewpreparationkit.dynamicprogramming

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.pow

/**
 * https://www.hackerrank.com/challenges/decibinary-numbers/problem
 * */
fun main() {
    val decibinaryNumbers = DecibinaryNumbers()
    println("${decibinaryNumbers.decibinaryNumbers(1)}, 0")
    println("${decibinaryNumbers.decibinaryNumbers(2)}, 1")
    println("${decibinaryNumbers.decibinaryNumbers(3)}, 2")
    println("${decibinaryNumbers.decibinaryNumbers(4)}, 10")
    println("${decibinaryNumbers.decibinaryNumbers(10)}, 100")
    println()

    println("${decibinaryNumbers.decibinaryNumbers(8)}, 12")
    println("${decibinaryNumbers.decibinaryNumbers(23)}, 23")
    println("${decibinaryNumbers.decibinaryNumbers(19)}, 102")
    println("${decibinaryNumbers.decibinaryNumbers(16)}, 14")
    println("${decibinaryNumbers.decibinaryNumbers(26)}, 111")
    println("${decibinaryNumbers.decibinaryNumbers(7)}, 4")
    println("${decibinaryNumbers.decibinaryNumbers(6)}, 11")
    println()

    println("${decibinaryNumbers.decibinaryNumbers(19)}, 102")
    println("${decibinaryNumbers.decibinaryNumbers(25)}, 103")
    println("${decibinaryNumbers.decibinaryNumbers(6)}, 11")
    println("${decibinaryNumbers.decibinaryNumbers(8)}, 12")
    println("${decibinaryNumbers.decibinaryNumbers(20)}, 110")
    println("${decibinaryNumbers.decibinaryNumbers(10)}, 100")
    println("${decibinaryNumbers.decibinaryNumbers(27)}, 8")
    println("${decibinaryNumbers.decibinaryNumbers(24)}, 31")
    println("${decibinaryNumbers.decibinaryNumbers(30)}, 32")
    println("${decibinaryNumbers.decibinaryNumbers(11)}, 5")
    println()
}

class DecibinaryNumbers {
    private val maxD = 19
    private val maxS = 300000
    private val pow2 = intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144)

    private fun createF() = List(maxD + 1) { LongArray(maxS + 1) }.apply {
        this[0][0] = 1
        for (d in 1..maxD) {
            for (s in 0..maxS) {
                for (i in 0..9) {
                    val previousS = s - i * pow2[d - 1]
                    if (previousS >= 0) this[d][s] += this[d - 1][previousS]
                }
            }
        }
    }

    private fun createC(f: List<LongArray>) = LongArray(maxS + 1).apply {
        this[0] = f[maxD][0]
        for (s in 1 until size) this[s] = this[s - 1] + f[maxD][s]
    }

    private fun findS(c: LongArray, x: Long): Int {
        val s = c.binarySearch(x)
        return if (s >= 0) s else -s - 1
    }

    private fun decibinaryNumbers(f: List<LongArray>, c: LongArray, x: Long): Long {
        var s = findS(c, x)
        var g = if (s > 0) x - c[s - 1] else x
        var decibinaryDigits = ""
        for (d in maxD downTo 1) {
            var i = 0
            var previousDecibinaryCount = 0L
            var decibinaryCount = 0L
            while (decibinaryCount < g) {
                previousDecibinaryCount = decibinaryCount
                decibinaryCount += f[d - 1][s - i++ * pow2[d - 1]]
            }
            i--
            decibinaryDigits += i
            s -= i * pow2[d - 1]
            g -= previousDecibinaryCount
        }
        return decibinaryDigits.toLong()
    }

    fun decibinaryNumbers(x: Long): Long {
        val f = createF()
        return decibinaryNumbers(f, createC(f), x)
    }
}