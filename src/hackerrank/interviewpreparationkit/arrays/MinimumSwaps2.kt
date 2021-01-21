package hackerrank.interviewpreparationkit.arrays

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 * */
fun main() {
    val minimumSwaps2 = MinimumSwaps2()
    println(minimumSwaps2.minimumSwaps(arrayOf(4, 3, 1, 2))) //3
    println(minimumSwaps2.minimumSwaps(arrayOf(2, 3, 4, 1, 5))) //3
    println(minimumSwaps2.minimumSwaps(arrayOf(1, 3, 5, 2, 4, 6, 7))) //3
}

class MinimumSwaps2 {
    fun minimumSwaps(arr: Array<Int>): Int {
        var swaps = 0
        for(i in arr.indices) {
            while(arr[i] - 1 != i) {
                if(arr[i] > i + 1) {
                    val first = arr[i]
                    val last = arr[first - 1]
                    arr[i] = last
                    arr[first - 1] = first
                    swaps += 1
                }
            }
        }
        return swaps
    }
}