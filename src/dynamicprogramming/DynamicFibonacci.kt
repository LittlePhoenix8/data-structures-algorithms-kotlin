package dynamicprogramming

val cacheFibonacci = HashMap<Int, Int>()
var calculation = 0

fun main() {
    println("Slow: ${fibonacci(35)}")
    println("DP: ${fibonacciMaster(35)}")
    println("we did $calculation calculations")
}

fun fibonacci(n: Int): Int {
    return if (n < 2) {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
} //O(2^n)

fun fibonacciMaster(n: Int): Int {
    calculation++
    return if (cacheFibonacci.containsKey(n)) {
        cacheFibonacci[n]!!
    } else {
        if (n < 2) {
            n
        } else {
            cacheFibonacci[n] = fibonacciMaster(n - 1) + fibonacciMaster(n - 2)
            cacheFibonacci[n]!!
        }
    }
} //O(n)