package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/spiral-matrix/
 * */
fun main() {
    val spiralMatrix = SpiralMatrix()
    println(spiralMatrix.spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))).joinToString(", ")) //[1, 2, 3, 6, 9, 8, 7, 4, 5]
    println(spiralMatrix.spiralOrder(arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))).joinToString(", ")) //[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
}

class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val spiral = ArrayList<Int>()
        dfs(matrix, 0, 0, 0, -1, spiral)
        return spiral
    }

    private fun dfs(matrix: Array<IntArray>, i: Int, j: Int, prevI: Int, prevJ: Int, spiral: ArrayList<Int>): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == -101) {
            return false
        }
        spiral.add(matrix[i][j])
        matrix[i][j] = -101
        if (prevI == i && prevJ == j - 1) {
            //move right or down
            if (!dfs(matrix, i, j + 1, i, j, spiral)) {
                dfs(matrix, i + 1, j, i, j, spiral)
            }
        }
        if (prevI == i && prevJ == j + 1) {
            //move left or up
            if (!dfs(matrix, i, j - 1, i, j, spiral)) {
                dfs(matrix, i - 1, j, i, j, spiral)
            }
        }
        if (prevI == i + 1 && prevJ == j) {
            //move up or right
            if (!dfs(matrix, i - 1, j, i, j, spiral)) {
                dfs(matrix, i, j + 1, i, j, spiral)
            }
        }
        if (prevI == i - 1 && prevJ == j) {
            //move down or left
            if (!dfs(matrix, i + 1, j, i, j, spiral)) {
                dfs(matrix, i, j - 1, i, j, spiral)
            }
        }
        return true
    }
}