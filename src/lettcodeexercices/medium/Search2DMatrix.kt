package lettcodeexercices.medium

/**
* https://leetcode.com/problems/search-a-2d-matrix/
* */
fun main() {
    val searchMatrix = Search2DMatrix()
    println(searchMatrix.searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 3)) //true
    println(searchMatrix.searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 11)) //true
    println(searchMatrix.searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 34)) //true

    println(searchMatrix.searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 2)) //false
    println(searchMatrix.searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), 70)) //false
}
class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val maxRows = matrix.size
        var i = 0
        while (i < maxRows) {
            val lastFromRow = matrix[i].last()
            if (target == lastFromRow) {
                return true
            } else if (target > lastFromRow) {
                //next row
                i++
            } else {
                // this row
                for (j in matrix[i].indices) {
                    if (matrix[i][j] == target) {
                        return true
                    }
                }
                return false
            }
        }
        return false
    }
}