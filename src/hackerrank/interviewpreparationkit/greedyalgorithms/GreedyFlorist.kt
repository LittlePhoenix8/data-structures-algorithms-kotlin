package hackerrank.interviewpreparationkit.greedyalgorithms

/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 * */
fun main() {
    val greedyFlorist = GreedyFlorist()
    println(greedyFlorist.getMinimumCost(3, arrayOf(2, 5, 6))) //13
    println(greedyFlorist.getMinimumCost(2, arrayOf(2, 5, 6))) //15
    println(greedyFlorist.getMinimumCost(3, arrayOf(3, 3, 5, 7, 9))) //29
}

class GreedyFlorist {
    fun getMinimumCost(k: Int, c: Array<Int>): Int {
        //k = nº of friends
        //c = cost of flowers
        c.sort()
        var minimumCost = 0
        var flowersBought = 0
        for (i in c.size - 1 downTo 0) {
            val cost = Math.floorDiv(flowersBought, k) + 1
            val addedCost = c[i] * cost
            minimumCost += addedCost
            flowersBought++
        }
        return minimumCost
    }
}