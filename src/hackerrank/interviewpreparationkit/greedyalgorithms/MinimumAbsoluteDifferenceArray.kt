package hackerrank.interviewpreparationkit.greedyalgorithms

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 * */
fun main() {
    val minimumAbsoluteDifferenceArray = MinimumAbsoluteDifferenceArray()
    println(minimumAbsoluteDifferenceArray.minimumAbsoluteDifference(arrayOf(3, -7, 0))) //3
    println(minimumAbsoluteDifferenceArray.minimumAbsoluteDifference(arrayOf(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75))) //1
    println(minimumAbsoluteDifferenceArray.minimumAbsoluteDifference(arrayOf(1, -3, 71, 68, 17))) //3
}

class MinimumAbsoluteDifferenceArray {
    fun minimumAbsoluteDifference(arr: Array<Int>): Int {
        //Arrays.sort(arr)
        arr.sort()
        var minAbsolute = Int.MAX_VALUE
        for (i in 0 until arr.size - 1) {
            val difference = arr[i + 1] - arr[i]
            if (difference < minAbsolute) {
                minAbsolute = difference
                if (minAbsolute == 0) {
                    return 0
                }
            }
        }
        return minAbsolute
    }
}