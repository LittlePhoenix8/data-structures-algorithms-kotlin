package udacity

/**
 * You're going to write a binary search function.
 * You should use an iterative approach - meaning using loops.
 * Your function should take two inputs: a Python list to search through, and the value you're searching for.
 * Assume the list only has distinct elements, meaning there are no repeated values, and
 * elements are in a strictly increasing order.
 * Return the index of value, or -1 if the value doesn't exist in the list.
 * */
fun main() {
    println(BinarySearch().binarySearch(arrayOf(1, 3, 9, 11, 15, 19, 29), 25)) //-1
    println(BinarySearch().binarySearch(arrayOf(1, 3, 9, 11, 15, 19, 29), 15)) //4
}
class BinarySearch {
    fun binarySearch(inputArray: Array<Int>, value: Int): Int {
        var start = 0
        var end = inputArray.size - 1
        while (start <= end) {
            val middle = (start + end) / 2
            when {
                value > inputArray[middle] -> {
                    //upp
                    start = middle + 1
                }
                value < inputArray[middle] -> {
                    //down
                    end = middle - 1
                }
                else -> {
                    //same
                    return middle
                }
            }
        }
        return -1
    }
}