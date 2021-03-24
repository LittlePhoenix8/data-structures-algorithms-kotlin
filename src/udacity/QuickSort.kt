package udacity

fun main() {
    val array = QuickSort().quickSort(arrayOf(21, 4, 1, 3, 9, 20, 25, 6, 21, 14))
    println(array.joinToString(", "))
}

class QuickSort {
    fun quickSort(array: Array<Int>): Array<Int> {
        val n = array.size
        for (pivot in array.indices) {
            var storeIndex = pivot + 1
            for (i in pivot + 1 until n) {
                if (array[i] < array[pivot]) {
                    swap(array, i, storeIndex)
                    storeIndex++
                    swap(array, pivot, storeIndex - 1)
                }
            }
        }
        return array
    }

    private fun swap(array: Array<Int>, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}