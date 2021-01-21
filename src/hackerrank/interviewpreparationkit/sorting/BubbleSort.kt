package hackerrank.interviewpreparationkit.sorting

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 * */
fun main() {
    val bubbleSort = BubbleSort()
    bubbleSort.countSwaps(arrayOf(1, 2, 3))
    bubbleSort.countSwaps(arrayOf(3, 2, 1))
}

class BubbleSort {
    fun countSwaps(a: Array<Int>) {
        var numSwaps = 0
        val n = a.size
        for (i in 0 until n) {
            for (j in 0 until n - 1) {
                // Swap elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numSwaps++
                }
            }
        }
        println("Array is sorted in $numSwaps swaps.")
        println("First Element: ${a[0]}")
        println("Last Element: ${a[n -1]}")
    }

    private fun swap(array: Array<Int>, i: Int, j: Int) {
        if (i == j) {
            return
        }
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}