package algorithms.recursion

fun main() {
    println("Iterative")
    println(fibonacciIterative(1)) //1
    println(fibonacciIterative(3)) //2
    println(fibonacciIterative(6)) //8
    println(fibonacciIterative(8)) //21

    println("Recursive")
    println(fibonacciRecursive(1)) //1
    println(fibonacciRecursive(3)) //2
    println(fibonacciRecursive(6)) //8
    println(fibonacciRecursive(8)) //21
}

// Given a number N return the index value of the Fibonacci sequence, where the sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3
//For example: fibonacciRecursive(6) should return 8

//O(n)
fun fibonacciIterative(n: Int): Int {
    val array = ArrayList<Int>()
    array.add(0)
    array.add(1)
    for (i in 2..n) {
        array.add(array[i - 2] + array[i - 1])
    }
    return array[n]
}

//Exponential Time
//O(2^n)
fun fibonacciRecursive(n: Int): Int {
    return if (n < 2) {
        n
    } else {
        fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }
}