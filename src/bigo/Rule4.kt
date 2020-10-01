package bigo

fun main() {
    printAllNumbersThenAllPairSums(arrayOf(1,2,3,4,5))
}

fun printAllNumbersThenAllPairSums(numbers: Array<Int>) {
    println("these are the numbers: ")
    numbers.forEach {
        println(it)
    }
    println("and these are their sums: ")
    numbers.forEach { firstNumber ->
        numbers.forEach { secondNumber ->
            println("${(firstNumber + secondNumber)}")
        }
    }
}
//O(n + n^2) -> O(n^2)