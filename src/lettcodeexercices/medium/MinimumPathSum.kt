package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * */
fun main() {
    val minimumPathSum = MinimumPathSum()
    println(minimumPathSum.minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1)))) //7
    println(minimumPathSum.minPathSum(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))) //12
}

class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array<IntArray>(m) { IntArray(n) }
        for (i in dp.indices) {
            if (i == 0) {
                dp[i][0] = grid[i][0]
            } else {
                dp[i][0] = grid[i][0] + dp[i - 1][0]
            }
        }
        for (i in 0 until dp[0].size) {
            if (i == 0) {
                dp[0][i] = grid[0][i]
            } else {
                dp[0][i] = grid[0][i] + dp[0][i - 1]
            }
        }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {
                val upSum = grid[i][j] + dp[i - 1][j]
                val leftSum = grid[i][j] + dp[i][j - 1]
                dp[i][j] = kotlin.math.min(upSum, leftSum)
            }
        }
        return dp[m - 1][n - 1]
    }
}