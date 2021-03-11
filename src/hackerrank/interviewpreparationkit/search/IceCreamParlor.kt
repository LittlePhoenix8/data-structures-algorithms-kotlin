package hackerrank.interviewpreparationkit.search

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 * */
fun main() {
    val iceCreamParlor = IceCreamParlor()
    iceCreamParlor.whatFlavors(arrayOf(1, 4, 5, 3, 2), 4) //1 4
    iceCreamParlor.whatFlavors(arrayOf(2, 2, 4, 3), 4) //1 2
    iceCreamParlor.whatFlavors(arrayOf(2, 1, 3, 5, 6), 5) //1 3
    iceCreamParlor.whatFlavors(arrayOf(4, 3, 2, 5, 7), 8) //2 4
    iceCreamParlor.whatFlavors(arrayOf(7, 2, 5, 4, 11), 12) //1 3
    //iceCreamParlor.whatFlavors(arrayOf(), 0) //
}

class IceCreamParlor {
    fun whatFlavors(cost: Array<Int>, money: Int) {
        val hashmap = HashMap<Int, Int>()
        for (i in cost.indices) {
            val price = cost[i]
            val rest = money - price
            if (hashmap.containsKey(rest)) {
                println("${hashmap[rest]} ${i + 1}")
                break
            } else {
                hashmap[cost[i]] = i + 1
            }
        }
    }
}