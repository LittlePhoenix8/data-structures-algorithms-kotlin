package hackerrank.interviewpreparationkit.sorting

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem
 * */
fun main() {
    val countingInversions = CountingInversions()
    println(countingInversions.countInversions(arrayOf(1, 1, 1, 2, 2))) //0
    println(countingInversions.countInversions(arrayOf(2, 1, 3, 1, 2))) //4
    println(countingInversions.countInversions(arrayOf(1, 5, 3, 7))) //1
    println(countingInversions.countInversions(arrayOf(7, 5, 3, 1))) //6
    println(countingInversions.countInversions(arrayOf(1, 3, 5, 7))) //0
    println(countingInversions.countInversions(arrayOf(3, 2, 1))) //3
}

class CountingInversions {
    var count: Long = 0

    fun countInversions(arr: Array<Int>): Long {
        //return countNotRecursive(arr)
        count = 0
        swap(arr, 0, arr.size)
        return count
    }

    private fun swap(arr: Array<Int>, start: Int, end: Int) {
        if(end - start < 2) {
            return
        }
        val mid = (start + end) / 2
        //split left array
        swap(arr, start, mid)
        //split right array
        swap(arr, mid, end)
        //merge & cound
        merge(arr, start, mid, end)
    }

    private fun merge(arr: Array<Int>, start: Int, mid: Int, end: Int) {
        if (arr[mid - 1] <= arr[mid]) {
            return
        }
        var i = start
        var j = mid
        var tempIndex = 0
        val temp = Array<Int>(end - start) { 0 }
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[tempIndex] = arr[i]
                i++
            } else {
                count += mid - i;
                temp[tempIndex] = arr[j]
                j++
            }
            tempIndex++
        }
        //copy sorted
        System.arraycopy(arr, i, arr, start + tempIndex, mid - i)
        //copy leftover
        System.arraycopy(temp, 0, arr, start, tempIndex)
    }
}