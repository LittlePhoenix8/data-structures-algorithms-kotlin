package algorithms.sorting

fun main() {
    val numbers = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    println(selectionSort(numbers).joinToString(", "))
    //0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283
}

fun selectionSort(array: Array<Int>): Array<Int> {
    for (i in 0 until array.size - 1) {
        var min = i
        val temp = array[i]
        for (j in i + 1 until array.size) {
            if (array[j] < array[min]) {
                min = j
            }
        }
        array[i] = array[min]
        array[min] = temp
    }
    return array
}