package lettcodeexercices.medium
/**
 * https://leetcode.com/problems/rotate-image/
 * */
fun main() {
    val rotateImage = RotateImage()
    val matrix1 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    rotateImage.rotate(matrix1)
    for (m in matrix1) {
        println(m.joinToString(", "))
    }
    println()

    val matrix2 = arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
    rotateImage.rotate(matrix2)
    for (m in matrix2) {
        println(m.joinToString(", "))
    }
    println()

    val matrix3 = arrayOf(intArrayOf(1))
    rotateImage.rotate(matrix3)
    for (m in matrix3) {
        println(m.joinToString(", "))
    }
    println()

    val matrix4 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    rotateImage.rotate(matrix4)
    for (m in matrix4) {
        println(m.joinToString(", "))
    }
    println()
}

class RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until n) {
            for (j in i until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n - 1 - j]
                matrix[i][n - 1 - j] = temp
            }
        }
    }
}