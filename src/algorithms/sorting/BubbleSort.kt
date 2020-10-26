package algorithms.sorting

fun main() {
    val numbers = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    bubbleSort(numbers)
    println(numbers.joinToString(", "))
    //0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283
}

fun bubbleSort(array: Array<Int>): Array<Int> {
    for (i in array.indices) {
        for (j in 0 until array.size - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
    return array
}