package hackerrank.interviewpreparationkit.arrays

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 * */
fun main() {
    val arraysLeftRotation = ArraysLeftRotation()
    val k = 4
    var a = intArrayOf(1, 2, 3, 4, 5)
    for (i in 0 until k) {
        a = arraysLeftRotation.rotateLeft(a)
    }
    println(a.joinToString(", ")) //5, 1, 2, 3, 4
}

class ArraysLeftRotation {
    fun rotateLeft(array: IntArray): IntArray {
        val temporal = array[0]
        for (i in 0 until array.size - 1) {
            array[i] = array[i + 1]
        }
        array[array.size - 1] = temporal
        return array
    }
}