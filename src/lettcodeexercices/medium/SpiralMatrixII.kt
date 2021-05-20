package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * */
fun main() {
    val spiralMatrix = SpiralMatrixII()
    printMatrix(spiralMatrix.generateMatrix(3)) //[[1, 2, 3], [8, 9, 4], [7, 6, 5]]
    printMatrix(spiralMatrix.generateMatrix(1)) //[[1]]
}

private fun printMatrix(intervals: Array<IntArray>) {
    for (i in intervals) {
        print("[")
        print(i.joinToString(", "))
        print("]")
    }
    println()
}

class SpiralMatrixII {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }
        val visited = Array(n) { IntArray(n) }
        dfs(matrix, 0, 0, 0, -1, 1, n, visited)
        return matrix
    }

    private fun dfs(matrix: Array<IntArray>, i: Int, j: Int, prevI: Int, prevJ: Int, number: Int, n: Int, visited: Array<IntArray>): Boolean {
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] == -1) {
            return false
        }
        matrix[i][j] = number
        visited[i][j] = -1
        if (prevI == i && prevJ == j - 1) {
            //move right or down
            if (!dfs(matrix, i, j + 1, i, j, number + 1, n, visited)) {
                dfs(matrix, i + 1, j, i, j, number + 1, n, visited)
            }
        }
        if (prevI == i && prevJ == j + 1) {
            //move left or up
            if (!dfs(matrix, i, j - 1, i, j, number + 1, n, visited)) {
                dfs(matrix, i - 1, j, i, j, number + 1, n, visited)
            }
        }
        if (prevI == i + 1 && prevJ == j) {
            //move up or right
            if (!dfs(matrix, i - 1, j, i, j, number + 1, n, visited)) {
                dfs(matrix, i, j + 1, i, j, number + 1, n, visited)
            }
        }
        if (prevI == i - 1 && prevJ == j) {
            //move down or left
            if (!dfs(matrix, i + 1, j, i, j, number + 1, n, visited)) {
                dfs(matrix, i, j - 1, i, j, number + 1, n, visited)
            }
        }
        return true
    }
}