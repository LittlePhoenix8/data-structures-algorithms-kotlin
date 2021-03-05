package hackerrank.interviewpreparationkit.trees

import kotlin.math.min
import java.util.*

/**
 * https://www.hackerrank.com/challenges/balanced-forest/problem
 * */
fun main() {
    val balancedForest = BalancedForest()
    println(balancedForest.balancedForest(arrayOf(1, 2, 2, 1, 1), arrayOf(arrayOf(1, 2), arrayOf(1, 3), arrayOf(3, 5), arrayOf(1, 4)))) //2
    println(balancedForest.balancedForest(arrayOf(1, 3, 5), arrayOf(arrayOf(1, 3), arrayOf(1, 2)))) //-1
}

class BalancedForest {
    class NodeForest(var cost: Long) {
        var visited = false
        var v2: Boolean = false
        var adjacent = ArrayList<Int>()
    }

    private var mini: Long = 0
    var sum: Long = 0
    var s = HashSet<Long>()
    private var q = HashSet<Long>()

    fun balancedForest(c: Array<Int>, edges: Array<Array<Int>>): Long {
        s = HashSet<Long>()
        q = HashSet<Long>()
        val nodes = ArrayList<NodeForest>()
        for (i in c.indices) {
            nodes.add(NodeForest(c[i].toLong()))
        }
        for (element in edges) {
            val edge: Array<Int> = element
            val a = edge[0] - 1
            val b = edge[1] - 1
            nodes[a].adjacent.add(b)
            nodes[b].adjacent.add(a)
        }
        mini = dfs(0, nodes).also { sum = it }
        solve(0, nodes)
        return if (mini == sum) -1 else mini
    }

    private fun dfs(p: Int, nodes: ArrayList<NodeForest>): Long {
        val node = nodes[p]
        if (node.visited) {
            return 0
        }
        node.visited = true
        for (i in 0 until node.adjacent.size) {
            node.cost += dfs(node.adjacent[i], nodes)
        }
        return node.cost
    }

    private fun solve(p: Int, nodes: ArrayList<NodeForest>) {
        val node = nodes[p]
        if (node.v2) return
        node.v2 = true
        //val x = longArrayOf(2 * node.cost, 2 * sum - 4 * node.cost, sum - node.cost)
        val y = longArrayOf(3 * node.cost - sum, (sum - node.cost) / 2 - node.cost)
        if (sum % 2 == 0L && node.cost == sum / 2) {
            mini = min(mini, sum / 2)
        }
        if (s.contains(node.cost)) {
            if (y[0] >= 0) mini = min(mini, y[0])
        }
        if (s.contains(sum - 2 * node.cost) || q.contains(sum - node.cost)) {
            if (y[0] >= 0) mini = mini.coerceAtMost(y[0])
        }
        if ((sum - node.cost) % 2 == 0.toLong()) {
            if (s.contains((sum - node.cost) / 2) || q.contains((sum + node.cost) / 2)) {
                if (y[1] >= 0) mini = min(mini, y[1])
            }
        }
        q.add(node.cost)
        for (i in 0 until node.adjacent.size) {
            solve(node.adjacent[i], nodes)
        }
        q.remove(node.cost)
        s.add(node.cost)
    }
}