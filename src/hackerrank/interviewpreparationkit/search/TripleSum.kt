package hackerrank.interviewpreparationkit.search

/**
 * https://www.hackerrank.com/challenges/triple-sum/problem
 * */
fun main() {
    val tripleSum = TripleSum()
    println(tripleSum.triplets(arrayOf(3, 5, 7), arrayOf(3, 6), arrayOf(4, 6, 9))) //4
    println(tripleSum.triplets(arrayOf(1, 3, 5), arrayOf(2, 3), arrayOf(1, 2, 3))) //8
    println(tripleSum.triplets(arrayOf(1, 4, 5), arrayOf(2, 3, 3), arrayOf(1, 2, 3))) //5
    println(tripleSum.triplets(arrayOf(1, 3, 5, 7), arrayOf(5, 7, 9), arrayOf(7, 9, 11, 13))) //12
}

class TripleSum {
    fun triplets(a: Array<Int>, b: Array<Int>, c: Array<Int>): Long {
        val setA = a.distinct().sorted()
        val setB = b.distinct().sorted()
        val setC = c.distinct().sorted()
        var triplets: Long = 0
        var i = 0
        var j = 0
        for (q in setB) {
            while (i < setA.size && setA[i] <= q) {
                i++
            }
            while (j < setC.size && setC[j] <= q) {
                j++
            }
            triplets += i.toLong() * j
        }
        return triplets
    }
}