package hackerrank.interviewpreparationkit.warmup

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 * */
fun main() {
    val salesByMatch = SalesByMatch()
    println(salesByMatch.sockMerchant(9, arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20))) //3
    println(salesByMatch.sockMerchant(10, arrayOf(1, 1, 3, 1, 2, 1, 3, 3, 3, 3))) //4
}

class SalesByMatch {
    fun sockMerchant(n: Int, ar: Array<Int>): Int {
        var pairs = 0
        val used = ArrayList<Int>()
        for(sock in ar.indices) {
            val first = ar[sock]
            val filter = ar.filter { data -> data == first }
            if (!used.contains(first)) {
                used.add(first)
                pairs += filter.size / 2
            }
        }
        return pairs
    }
}