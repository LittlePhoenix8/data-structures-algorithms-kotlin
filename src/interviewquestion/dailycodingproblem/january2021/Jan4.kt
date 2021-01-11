package interviewquestion.dailycodingproblem.january2021

/**
 * This problem was asked by Facebook.
 * Given a array of numbers representing the stock prices of a company in chronological order,
 * write a function that calculates the maximum profit you could have made from buying and selling that stock once.
 * You must buy before you can sell it.
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 * */
fun main() {
    println(getMainProfit(intArrayOf(9, 11, 8, 5, 7, 10))) //5
}

fun getMainProfit(stocks: IntArray): Int {
    var maxProfit = 0
    for (i in stocks.indices) {
        for (j in i + 1 until stocks.size) {
            val profit = stocks[j] - stocks[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
    }
    return maxProfit
}