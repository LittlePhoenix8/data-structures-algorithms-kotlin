package algorithms.sorting

fun main() {
    val numbers = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    val answer = mergeSort(numbers)
    println(answer.joinToString(" "))
}

fun mergeSort (array: Array<Int>): Array<Int> {
    if (array.size == 1) {
        return array
    }
    // Split Array in into right and left
    val length = array.size
    val middle = length / 2
    val left = array.copyOfRange(0, middle)
    val right = array.copyOfRange(middle, length)
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
    val result = ArrayList<Int>()
    var leftIndex = 0
    var rightIndex = 0
    while (leftIndex < left.size && rightIndex < right.size) {
        if (left[leftIndex] < right[rightIndex]) {
            result.add(left[leftIndex])
            leftIndex++
        } else {
            result.add(right[rightIndex])
            rightIndex++
        }
    }
    val leftRemaining = left.copyOfRange(leftIndex, left.size)
    val rightRemaining = right.copyOfRange(rightIndex, right.size)
    result.addAll(leftRemaining)
    result.addAll(rightRemaining)
    return result.toTypedArray()
}