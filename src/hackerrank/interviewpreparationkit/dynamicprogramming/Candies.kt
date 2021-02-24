package hackerrank.interviewpreparationkit.dynamicprogramming

/**
 * https://www.hackerrank.com/challenges/candies/problem
 * */
fun main() {
    val candies = Candies()
    println("${candies.candies(3, arrayOf(1, 2, 2))}, 4")
    println("${candies.candies(10, arrayOf(2, 4, 2, 6, 1, 7, 8, 9, 2, 1))}, 19")
    println("${candies.candies(8, arrayOf(2, 4, 3, 5, 2, 6, 4, 5))}, 12")
}

class Candies {
    fun candies(n: Int, arr: Array<Int>): Long {
        var sum: Long = 0
        val candies = Array(n) { 0 }
        candies[0] = 1
        //forward
        for (i in 1 until arr.size) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1
            } else {
                candies[i] = 1
            }
        }
        //backwards
        for (i in arr.size - 1 downTo 1) {
            if (arr[i] < arr[i - 1]) {
                candies[i - 1] = kotlin.math.max(candies[i - 1], candies[i] + 1)
            }
        }
        candies.forEach { sum += it }
        return sum
    }
}