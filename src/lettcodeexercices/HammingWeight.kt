package lettcodeexercices

fun main() {
    val hammingWeight = HammingWeight()
    println(hammingWeight.hammingWeight(521)) //3
    println(hammingWeight.hammingWeight(2097152)) //1
}

class HammingWeight {
    fun hammingWeight(n: Int): Int {
        var number = n
        var count = 0
        while (number != 0) {
            number = number and (number - 1)
            count++
        }
        return count
    }
}