package hackerrank.interviewpreparationkit.graphs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * https://www.hackerrank.com/challenges/find-the-nearest-clone/problem
 * */
fun main() {
    val findNearestClone = FindNearestClone()
    println(findNearestClone.findShortest(4, arrayOf(1, 1, 4), arrayOf(2, 3, 2), arrayOf(1, 2, 1, 1), 1)) //1
    println(findNearestClone.findShortest(4, arrayOf(1, 1, 4), arrayOf(2, 3, 2), arrayOf(1, 2, 3, 4), 2)) //-1
    println(findNearestClone.findShortest(5, arrayOf(1, 1, 2, 3), arrayOf(2, 3, 4, 5), arrayOf(1, 2, 3, 3, 2), 2)) //3
}

class FindNearestClone {
    fun findShortest(graphNodes: Int, graphFrom: Array<Int>, graphTo: Array<Int>, ids: Array<Long>, variable: Int): Int {
        val adjacent = Array<ArrayList<Int>>(graphNodes) { ArrayList() }
        val distances = HashMap<Int, Int>()
        for (i in graphFrom.indices) {
            adjacent[graphFrom[i] - 1].add(graphTo[i])
            adjacent[graphTo[i] - 1].add(graphFrom[i])
        }
        val queue: Queue<Int> = LinkedList()
        for (i in ids.indices) {
            if (ids[i] == variable.toLong()) {
                queue.add(i + 1)
                distances[i + 1] = 0
            }
        }
        if (queue.size < 2) {
            return -1
        }
        val visited = HashSet<Int>()
        //dfs
        while (queue.isNotEmpty()) {
            val current = queue.remove()
            visited.add(current)
            for (a in adjacent[current - 1]) {
                if (distances.containsKey(a) && !visited.contains(a)) {
                    return distances[a]!! + distances[current]!! + 1
                } else {
                    queue.add(a)
                    distances[a] = distances[current]!! + 1
                }
            }
        }
        return -1
    }
}