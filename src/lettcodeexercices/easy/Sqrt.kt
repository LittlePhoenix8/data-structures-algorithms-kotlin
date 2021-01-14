package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/sqrtx/
 * */
fun main() {
    val sqrt = Sqrt()
    println(sqrt.mySqrt(4)) //2
    println(sqrt.mySqrt(8)) //2
}

class Sqrt {
    fun mySqrt(x: Int): Int {
        if (x < 4) {
            return if (x == 0) {
                0
            } else {
                1
            }
        }
        var r = x.toLong()
        while (r * r > x) {
            r = (r + x / r) / 2
        }
        return r.toInt()
    }
}