package hackerrank.interviewpreparationkit.recursion

/**
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
 * */
fun main() {
    val fibonacciNumbers = FibonacciNumbers()
    println(fibonacciNumbers.fibonacci(5)) //5
    println(fibonacciNumbers.fibonacci(12)) //144
    println(fibonacciNumbers.fibonacci(17)) //1597
}

class FibonacciNumbers {
    fun fibonacci(n: Int): Int {
        return getFibonacci(n)
    }

    private fun getFibonacci(n: Int): Int {
        if (n == 0) {
            return 0
        }
        return if (n == 1) {
            1
        } else getFibonacci(n - 1) + getFibonacci(n - 2)
    }
}