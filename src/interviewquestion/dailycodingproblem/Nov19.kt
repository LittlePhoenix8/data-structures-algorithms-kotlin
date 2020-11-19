package interviewquestion.dailycodingproblem

/*
* This problem was recently asked by Google.
* Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
* For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
* */
fun main() {
    println(numberIsSumOf(intArrayOf(10, 15, 3, 7), 17)) //true
    println(numberIsSumOf2(intArrayOf(10, 15, 3, 7), 17)) //true
    println(numberIsSumOf2(intArrayOf(10, 15, 3, 7), 19)) //true
}

fun numberIsSumOf(numbers: IntArray, k: Int): Boolean {
    for (i in numbers.indices) {
        for (j in 1 until numbers.size) {
            if (numbers[i] + numbers[j] == k) {
                return true
            }
        }
    }
    return false
}//O(n^2)

fun numberIsSumOf2(numbers: IntArray, k: Int): Boolean {
    val hashmap = HashMap<Int, Int>()
    for (i in numbers.indices) {
        val rest = k - numbers[i]
        if (hashmap.containsKey(rest)) {
            return true
        }
        hashmap[numbers[i]] = numbers[i]
    }
    return false
}//O(n)