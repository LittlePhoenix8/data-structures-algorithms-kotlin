package hackerrank.interviewpreparationkit.graphs

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 * */
fun main() {
    val graph = ShortestReachInGraph.Graph(6)
    val edges = arrayOf(arrayOf(1, 2), arrayOf(2, 3), arrayOf(3, 4), arrayOf(1, 5))
    for (pair in edges) {
        graph.addEdge(pair.first(), pair.last())
    }
    val distances = graph.shortestReach(1)
    println(distances.joinToString(", ")) //[6, 12, 18, 6, -1]
}

class ShortestReachInGraph {
    class Graph(val size: Int) {
        private val adjacent = Array<ArrayList<Int>>(size + 1) { ArrayList() }
        private val edge = 6

        fun addEdge(first: Int, second: Int) {
            adjacent[first].add(second)
            adjacent[second].add(first)
        }

        fun shortestReach(startId: Int): Array<Int> {
            val distances = Array(size) { -1 }
            if (distances.size <= 1) {
                return distances
            }
            //dfs from start add edge sum
            val queue: Queue<Int> = LinkedList()
            queue.add(startId)
            distances[startId] = 0
            while (queue.isNotEmpty()) {
                val current = queue.remove()
                for (adj in adjacent[current]) {
                    if (distances[adj] == -1) {
                        distances[adj] = distances[current] + edge
                        queue.add(adj)
                    }
                }
            }
            return distances
        }
    }
}