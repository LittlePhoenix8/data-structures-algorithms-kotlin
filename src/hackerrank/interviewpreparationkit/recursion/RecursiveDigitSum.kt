package hackerrank.interviewpreparationkit.recursion

/**
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 * */
fun main() {
    val recursiveDigitSum = RecursiveDigitSum()
    println(recursiveDigitSum.superDigit("148", 3)) //3
    println(recursiveDigitSum.superDigit("9875", 4)) //8
    println(recursiveDigitSum.superDigit("123", 3)) //9
}

class RecursiveDigitSum {
    fun superDigit(n: String, k: Int): Int {
        val sum = getSum(n) * k
        return getSuperDigit(sum.toString())
    }

    private fun getSuperDigit(num: String): Int {
        if(num.length == 1) {
            return num.toInt()
        }
        return getSuperDigit(getSum(num).toString())
    }

    private fun getSum(num: String): Long {
        var sum: Long = 0
        for(n in num.toCharArray()) {
            sum += Character.getNumericValue(n)
        }
        return sum
    }
}