package lettcodeexercices

fun main() {
}

class ReverseBits {
    fun reverseBits(n: Int) :Int {
        if (n == 0) {
            return 0
        }
        var number = n
        var result = 0
        for (i in 0 until 32) {
            result = result shl 1
            if (number and 1 == 1) {
                result++
            }
            number = number shr 1
        }
        return result
    }
}