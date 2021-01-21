package hackerrank.interviewpreparationkit.arrays

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 * */
fun main() {
    val array2D = Array2D()
    val array1 = arrayOf(1, 1, 1, 0, 0, 0)
    val array2 = arrayOf(0, 1, 0, 0, 0, 0)
    val array3 = arrayOf(1, 1, 1, 0, 0, 0)
    val array4 = arrayOf(0, 0, 2, 4, 4, 0)
    val array5 = arrayOf(0, 0, 0, 2, 0, 0)
    val array6 = arrayOf(0, 0, 1, 2, 4, 0)
    println(array2D.hourglassSum(arrayOf(array1, array2, array3, array4, array5, array6))) //19
}

class Array2D {
    fun hourglassSum(arr: Array<Array<Int>>): Int {
        var max = Int.MIN_VALUE
        for(y in 0..arr.size - 3) {
            val result = sumArray(arr[y], arr[y + 1], arr[y + 2])
            if(result > max) {
                max = result
            }
        }
        return max
    }
    private fun sumArray(first: Array<Int>, second: Array<Int>, third: Array<Int>): Int {
        var sum = Int.MIN_VALUE
        for(x in 0..first.size - 3) {
            var sumFirst = first[x] + first[x + 1] + first[x + 2]
            sumFirst += second[x + 1]
            sumFirst += third[x] + third[x + 1] + third[x + 2]
            if(sumFirst > sum) {
                sum = sumFirst
            }
        }
        return sum
    }
}