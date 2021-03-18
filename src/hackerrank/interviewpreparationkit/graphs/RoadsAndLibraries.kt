package hackerrank.interviewpreparationkit.graphs

import kotlin.math.min

/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 * */
fun main() {
    val roadsAndLibraries = RoadsAndLibraries()
    println(roadsAndLibraries.roadsAndLibraries(8, 3, 2, listOf(Pair(1, 7), Pair(1, 3), Pair(1, 2), Pair(2, 3), Pair(5, 6), Pair(6, 8)))) //19
    println(roadsAndLibraries.roadsAndLibraries(3, 2, 1, listOf(Pair(1, 2), Pair(3, 1), Pair(2, 3)))) //4
    println(roadsAndLibraries.roadsAndLibraries(6, 2, 5, listOf(Pair(1, 3), Pair(3, 4), Pair(2, 4), Pair(1, 2), Pair(2, 3), Pair(5, 6)))) //12
    println(roadsAndLibraries.roadsAndLibraries(5, 6, 1, listOf(Pair(1, 2), Pair(1, 3), Pair(1, 4)))) //15
}

class RoadsAndLibraries {
    fun roadsAndLibraries(n: Int, costLib: Long, costRoad: Long, cities: List<Pair<Int, Int>>): Long {
        if (costRoad > costLib) {
            //cheaper to build a library on every city
            return (costLib * n).toLong()
        }
        //dfs to look for adjacent cities, then build 1 library for every group of cities and build roads to connect them
        val adjacent = Array<ArrayList<Int>>(n + 1) { ArrayList() }
        /*for (i in 0 until n + 1) {
            adjacent.add(ArrayList())
        }*/
        for (pair in cities) {
            adjacent[pair.first].add(pair.second)
            adjacent[pair.second].add(pair.first)
        }
        val comp = ArrayList<Long>()
        val visited = Array(n + 1) { false }
        for (i in 1..n) {
            if (adjacent[i].isNotEmpty() && !visited[i]) {
                comp.add(dfs(adjacent, i, visited))
            } else if (adjacent[i].isEmpty()) {
                comp.add(1)
            }
        }
        var answer: Long = 0
        for (i in comp.indices) {
            //min between building 1 lib + roads and building 1 lib per city
            answer += min(((comp[i] - 1) * costRoad) + costLib, comp[i] * costLib)
        }
        return answer
    }

    private fun dfs(adjacent: Array<ArrayList<Int>>, i: Int, visited: Array<Boolean>): Long {
        visited[i] = true
        var answer: Long = 1
        for (j in adjacent[i].indices) {
            if (!visited[adjacent[i][j]]) {
                answer += dfs(adjacent, adjacent[i][j], visited)
            }
        }
        return answer
    }
}