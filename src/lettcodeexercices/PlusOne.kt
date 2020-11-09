package lettcodeexercices

fun main() {
    val plusOne = PlusOne()
    println(plusOne.plusOne(intArrayOf(1, 2, 3)).joinToString(",")) //[1, 2, 4]
    println(plusOne.plusOne(intArrayOf(4, 3, 2, 1)).joinToString(",")) //[4, 3, 2, 2]
    println(plusOne.plusOne(intArrayOf(0)).joinToString(",")) //[1]
    println(plusOne.plusOne(intArrayOf(9)).joinToString(",")) //[1, 0]
    println(plusOne.plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)).joinToString(","))
}

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val n = digits.size - 1
        for (i in n downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            } else {
                digits[i] = 0
            }
        }
        if (digits[0] == 0) {
            val newArray = IntArray(digits.size + 1)
            newArray[0] = 1
            return newArray
        }
        return digits
    }
}