package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * */
fun main() {
    val setMatrixZeroes = SetMatrixZeroes()
    val matrix1 = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
    setMatrixZeroes.setZeroes(matrix1)
    printMatrix(matrix1)

    val matrix2 = arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))
    setMatrixZeroes.setZeroes(matrix2)
    printMatrix(matrix2)
}
private fun printMatrix(matrix: Array<IntArray>) {
    for (m in matrix) {
        println(m.joinToString(", "))
    }
    println()
}

class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) {
           return
        }
        val m = matrix.size
        val n = matrix[0].size
        var firstRowZero = false
        var firstColZero = false
        for (j in 0 until n) {
            if (matrix[0][j] == 0) {
                firstRowZero = true
                break
            }
        }
        for (i in 0 until m) {
            if (matrix[i][0] == 0) {
                firstColZero = true
                break
            }
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }
        if (firstRowZero) {
            for (j in 0 until n) {
                matrix[0][j] = 0
            }
        }
        if (firstColZero) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }
    }
}