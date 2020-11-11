package lettcodeexercices

fun main() {
    val factorialTrailingZeroes = FactorialTrailingZeroes()
    println(factorialTrailingZeroes.trailingZeroes(3)) //0
    println(factorialTrailingZeroes.trailingZeroes(5)) //1
    println(factorialTrailingZeroes.trailingZeroes(0)) //0
    println(factorialTrailingZeroes.trailingZeroes(7)) //1
    println(factorialTrailingZeroes.trailingZeroes(10)) //2
    println(factorialTrailingZeroes.trailingZeroes(13)) //2
    println(factorialTrailingZeroes.trailingZeroes(30)) //7
    println(factorialTrailingZeroes.trailingZeroes(5146)) //1284
}

class FactorialTrailingZeroes {
    fun trailingZeroes(n: Int): Int {
        return if (n == 0) 0 else n / 5 + trailingZeroes(n / 5)
    }
}