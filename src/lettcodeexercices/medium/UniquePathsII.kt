package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * */
fun main() {
    val uniquePaths = UniquePathsII()
    println(uniquePaths.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)))) //2
    println(uniquePaths.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 0)))) //1
    println(uniquePaths.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0)))) //0
    println(uniquePaths.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 1), intArrayOf(0, 0)))) //1
    println(uniquePaths.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)))) //0
    println(uniquePaths.uniquePathsWithObstacles(arrayOf(intArrayOf(1, 0)))) //0
}

class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val dp = Array(m) { IntArray(n) }
        var hasObstacle = false
        //fill first column
        for (i in dp.indices) {
            if (hasObstacle || obstacleGrid[i][0] == 1) {
                hasObstacle = true
                dp[i][0] = 0
            } else {
                dp[i][0] = 1
            }
        }
        hasObstacle = false
        //fill first row
        for (i in 0 until dp[0].size) {
            if (hasObstacle || obstacleGrid[0][i] == 1) {
                hasObstacle = true
                dp[0][i] = 0
            } else {
                dp[0][i] = 1
            }
        }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {
                dp[i][j] = if (obstacleGrid[i][j] == 1) 0 else dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }

    fun uniquePathsWithObstacles2(dp: Array<IntArray>): Int {
        val m = dp.size
        val n = dp[0].size
        for (i in dp.indices) {
            for (j in 0 until n) {
                if (dp[i][j] == 1) {
                    dp[i][j] = -1
                }
            }
        }
        for (i in dp.indices) {
            if (dp[i][0] == -1) {
                break
            } else if (dp[i][0] == 0) {
                dp[i][0] = 1
            }
        }
        for (i in 0 until dp[0].size) {
            if (dp[0][i] == -1) {
                break
            } else if (dp[0][i] == 0) {
                dp[0][i] = 1
            }
        }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {
                if (dp[i][j] != -1) {
                    //up + left
                    val up = if (dp[i - 1][j] != -1) dp[i - 1][j] else 0
                    val left = if (dp[i][j - 1] != -1) dp[i][j - 1] else 0
                    dp[i][j] = up + left
                }
            }
        }
        return if (dp[m - 1][n - 1] != -1) dp[m - 1][n - 1] else 0
    }
}