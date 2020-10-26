package algorithms.sorting

fun main() {
    val numbers = arrayListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    insertionSort(numbers)
    println(numbers.joinToString(", "))
    //0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283
}

fun insertionSort(array: ArrayList<Int>): ArrayList<Int> {
    for (i in array.indices) {
        if (array[i] <= array[0]) {
            //move number to the first position
            array.add(0, array.removeAt(i))
        } else {
            // only sort number smaller than number on the left of it.
            for (j in 1 until i) {
                if (array[i] > array[j  - 1] && array[i] < array[j]) {
                    array.add(j, array.removeAt(i))
                    break
                }
            }
        }
    }
    return array
}