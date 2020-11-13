package lettcodeexercices

fun main() {}

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