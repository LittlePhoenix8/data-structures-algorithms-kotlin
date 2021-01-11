package lettcodeexercices

fun main() {
    val maxProfit = MaxProfit()
    println(maxProfit.maxProfit(intArrayOf(7,1,5,3,6,4))) //5
    println(maxProfit.maxProfit(intArrayOf(7,6,4,3,1))) //0
    println(maxProfit.maxProfit(intArrayOf(2,4,1))) //2
    println(maxProfit.maxProfit(intArrayOf(2, 1, 2, 1, 0, 1, 2))) //2
    println(maxProfit.maxProfit(intArrayOf(9, 11, 8, 5, 7, 10))) //5
}

class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for (i in prices.indices) {
            for (j in i + 1 until prices.size) {
                val profit = prices[j] - prices[i]
                if (profit > maxProfit) {
                    maxProfit = profit
                }
            }
        }
        return maxProfit
    }
}