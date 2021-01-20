package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * */
fun main() {
    val maxProfit2 = MaxProfit2()
    println(maxProfit2.maxProfit(intArrayOf(7,1,5,3,6,4))) //7
    println(maxProfit2.maxProfit(intArrayOf(1,2,3,4,5))) //4
    println(maxProfit2.maxProfit(intArrayOf(7,6,4,3,1))) //0
}

class MaxProfit2 {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for (i in prices.indices) {
            if (i + 1 < prices.size) {
                val profit = prices[i + 1] - prices[i]
                if (profit > 0) {
                    maxProfit += profit
                }
            }
        }
        return maxProfit
    }
}