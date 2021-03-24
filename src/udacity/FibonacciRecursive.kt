package udacity

fun main() {
    println(FibonacciRecursive().getFib(9))
    println(FibonacciRecursive().getFib(11))
    println(FibonacciRecursive().getFib(0))
}

class FibonacciRecursive {
    fun getFib(number: Int): Int {
        if (number < 2) {
            return number
        }
        return getFib(number - 1) + getFib(number - 2)
    }
}