package datastructures.arrays

fun main() {
    println(mergeSortedArray(arrayOf(0, 3, 4, 31), arrayOf(4, 6, 30)).joinToString(","))
    println(mergeSortedArray(arrayOf(0, 3, 4, 31, 45, 60), arrayOf(4, 6, 30)).joinToString(","))
}
/**
 * Given 2 arrays that are sorted, merge the two arrays into one that is still sorted.
 * array1 = [0, 3, 4, 31]
 * array2 = [4, 6, 30]
 * [0, 3, 4, 4, 6, 30, 31]
 */
fun mergeSortedArray(array1: Array<Int>, array2: Array<Int>):Array<Int> {
    if (array1.isEmpty()) {
        return array2
    }
    if (array2.isEmpty()) {
        return array1
    }
    val sortedArray = Array(array1.size + array2.size) { 0 }
    var i = 0
    var j = 0
    for (index in sortedArray.indices) {
        if (i < array1.size && j < array2.size) {
            if (array1[i] < array2[j]) {
                sortedArray[index] = array1[i]
                i++
            } else {
                sortedArray[index] = array2[j]
                j++
            }
        } else if (i < array1.size) {
            sortedArray[index] = array1[i]
            i++
        } else if (j < array2.size) {
            sortedArray[index] = array2[j]
            j++
        }
    }
    return sortedArray
}