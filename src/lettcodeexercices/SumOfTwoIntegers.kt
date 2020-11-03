package lettcodeexercices

fun main() {
    println(SumOfTwoIntegers().getSum(1, 2))
}

class SumOfTwoIntegers {
    fun getSum(a: Int, b: Int): Int {
        return a.plus(b)
    }
}