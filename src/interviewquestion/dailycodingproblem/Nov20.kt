package interviewquestion.dailycodingproblem

/**
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i of the
 * new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * */
fun main() {
    println(arrayProducts(intArrayOf(1, 2, 3, 4, 5)).joinToString(", ")) //[120, 60, 40, 30, 24]
    println(arrayProducts(intArrayOf(3, 2, 1)).joinToString(", ")) //[2, 3, 6]

    println(arrayProducts2(intArrayOf(1, 2, 3, 4, 5)).joinToString(", ")) //[120, 60, 40, 30, 24]
    println(arrayProducts2(intArrayOf(3, 2, 1)).joinToString(", ")) //[2, 3, 6]
}

fun arrayProducts(array: IntArray): IntArray {
    val list = ArrayList<Int>()
    for (i in array.indices) {
        var mult = 1
        for (j in array.indices) {
            if (j != i) {
                mult *= array[j]
            }
        }
        list.add(mult)
    }
    return list.toIntArray()
} //O(n^2)

fun arrayProducts2(array: IntArray): IntArray {
    val list = ArrayList<Int>()
    var mult = 1
    for (num in array) {
        mult *= num
    }
    for (i in array.indices) {
        val value = mult / array[i]
        list.add(value)
    }
    return list.toIntArray()
} //O(2n)
