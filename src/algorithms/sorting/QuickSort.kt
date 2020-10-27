package algorithms.sorting

fun main() {
    val numbers = arrayListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    quickSort(numbers, 0, numbers.size - 1)
    println(numbers.joinToString(" "))
}

fun quickSort(array: ArrayList<Int>, left: Int, right: Int): ArrayList<Int> {
    val pivot: Int
    val partitionIndex: Int
    if(left < right) {
        pivot = right
        partitionIndex = partition(array, pivot, left, right)
        //sort left and right
        quickSort(array, left, partitionIndex - 1)
        quickSort(array, partitionIndex + 1, right)
    }
    return array
}

fun partition(array: ArrayList<Int>, pivot: Int, left: Int, right: Int): Int {
    val pivotValue = array[pivot]
    var partitionIndex = left
    for(i in left until right) {
        if(array[i] < pivotValue) {
            swap(array, i, partitionIndex)
            partitionIndex++
        }
    }
    swap(array, right, partitionIndex)
    return partitionIndex
}

fun swap(array: ArrayList<Int>, firstIndex: Int, secondIndex: Int) {
    val temp = array[firstIndex]
    array[firstIndex] = array[secondIndex]
    array[secondIndex] = temp
}