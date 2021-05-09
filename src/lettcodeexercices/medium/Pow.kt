package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/powx-n/
 * */
fun main() {
    val pow = Pow()
    println(pow.myPow(2.00000, 10)) //1024.00000
    println(pow.myPow(2.10000, 3)) //9.26100
    println(pow.myPow(2.00000, -2)) //0.25
    println(pow.myPow(1.00000, 2147483647)) //1.00000
    println(pow.myPow(1.00000, -2147483648)) //1.00000
}

class Pow {
    fun myPow(x: Double, n: Int): Double {
        return powHelper(x, n.toLong())
    }

    private fun powHelper(x: Double, n: Long): Double {
        if (n == 0.toLong()) {
            return 1.0
        }
        if (n == 1.toLong()) {
            return x
        }
        if (n < 0) {
            return 1 / powHelper(x, -n)
        }
        if (n % 2 == 0.toLong()) {
            return powHelper(x * x, n / 2)
        }
        return x * powHelper(x * x, (n - 1) / 2)
    }
}