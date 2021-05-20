package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/unique-paths/
 * */
fun main() {
    val uniquePaths = UniquePaths()
    println(uniquePaths.uniquePaths(3, 7)) //28
    println(uniquePaths.uniquePaths(3, 2)) //3
    println(uniquePaths.uniquePaths(7, 3)) //28
    println(uniquePaths.uniquePaths(3, 3)) //6
}

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        for (i in dp.indices) {
            dp[i][0] = 1
        }
        for (i in 0 until dp[0].size) {
            dp[0][i] = 1
        }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {
                //up + left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}