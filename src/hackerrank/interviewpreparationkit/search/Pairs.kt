package hackerrank.interviewpreparationkit.search

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 * */
fun main() {
    val pairs = Pairs()
    println(pairs.pairs(1, arrayOf(1, 2, 3, 4))) //3
    println(pairs.pairs(2, arrayOf(1, 5, 3, 4, 2))) //3
}

class Pairs {
    fun pairs(k: Int, arr: Array<Int>): Int {
        val hashmap = HashMap<Int, Int>()
        var pairs = 0
        for (i in arr.indices) {
            hashmap[arr[i]] = 0
        }
        for(i in arr.indices) {
            val rest = k + arr[i]
            if (hashmap.containsKey(rest)) {
                pairs++
            }
        }
        return pairs
    }
}