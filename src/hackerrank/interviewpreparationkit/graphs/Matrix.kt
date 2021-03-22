package hackerrank.interviewpreparationkit.graphs

import kotlin.math.max
import kotlin.math.min

/**
 * https://www.hackerrank.com/challenges/matrix/problem
 * */
fun main() {
    println(Matrix().minTime(arrayOf(arrayOf(2, 1, 8), arrayOf(1, 0, 5), arrayOf(2, 4, 5), arrayOf(1, 3, 4)), arrayOf(2, 4, 0))) //10
    println(Matrix().minTime(arrayOf(arrayOf(0, 1, 4), arrayOf(1, 2, 3), arrayOf(1, 3, 7), arrayOf(0, 4, 2)), arrayOf(2, 3, 4))) //5
}

class Matrix {
    var total = 0
    fun minTime(roads: Array<Array<Int>>, machines: Array<Int>): Int {
        val n = roads.size
        val isMachine = Array(n + 1) { false }
        for (m in machines) {
            isMachine[m] = true
        }
        val adjacent = Array<ArrayList<NodeTime>>(n + 1) { ArrayList() }
        for (edge in roads) {
            adjacent[edge[0]].add(NodeTime(edge[1], edge[2]))
            adjacent[edge[1]].add(NodeTime(edge[0], edge[2]))
        }
        val visited = Array(n + 1) { false }
        dfs(0, 0, visited, adjacent, isMachine)
        return total
    }

    private fun dfs(city: Int, time: Int, visited: Array<Boolean>, adj: Array<ArrayList<NodeTime>>, isMachine: Array<Boolean>): Int {
        visited[city] = true
        var maxTime = 0
        var sumTime = 0
        for (nextCity in adj[city]) {
            if (!visited[nextCity.node]) {
                val nTime = dfs(nextCity.node, nextCity.time, visited, adj, isMachine)
                sumTime += nTime
                maxTime = max(maxTime, nTime)
            }
        }
        return if (isMachine[city]) {
            total += sumTime
            time
        } else {
            total += (sumTime - maxTime)
            min(maxTime, time)
        }
    }

    class NodeTime(var node: Int, var time: Int)
}