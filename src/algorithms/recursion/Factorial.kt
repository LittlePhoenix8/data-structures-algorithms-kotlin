package algorithms.recursion

fun main() {
    println(findFactorialRecursive(5))
    println(findFactorialIterative(5))
}

// Write two functions that finds the factorial of any number.
// One should use recursive, the other should just use a for loop
fun findFactorialRecursive(number: Int): Int {
    return if (number < 2) {
        1
    } else {
        number * findFactorialRecursive(number - 1)
    }
}

fun findFactorialIterative(number: Int): Int {
    return if (number < 2) {
        1
    } else {
        var factorial = 1
        for (i in 2..number) {
            factorial *= i
        }
        factorial
    }
}