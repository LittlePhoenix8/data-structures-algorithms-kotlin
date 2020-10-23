package datastructures.graphs

import java.lang.StringBuilder

fun main() {
    val myGraph = MyGraph()
    myGraph.addVertex(0)
    myGraph.addVertex(1)
    myGraph.addVertex(2)
    myGraph.addVertex(3)
    myGraph.addVertex(4)
    myGraph.addVertex(5)
    myGraph.addVertex(6)
    myGraph.addEdge(3, 1)
    myGraph.addEdge(3, 4)
    myGraph.addEdge(4, 2)
    myGraph.addEdge(4, 5)
    myGraph.addEdge(1, 2)
    myGraph.addEdge(1, 0)
    myGraph.addEdge(0, 2)
    myGraph.addEdge(6, 5)
    myGraph.showConnections()
    //Answer:
    // 0 --> 1 2
    // 1 --> 3 2 0
    // 2 --> 4 1 0
    // 3 --> 1 4
    // 4 --> 3 2 5
    // 5 --> 4 6
    // 6 --> 5
}

class MyGraph {
    private var numberOfNodes = 0
    private var adjacentList = HashMap<Int, ArrayList<Int>>()

    fun addVertex(node: Int) {
        adjacentList[node] = ArrayList()
        numberOfNodes++
    }

    fun addEdge(node1: Int, node2: Int) {
        adjacentList[node1]?.add(node2)
        adjacentList[node2]?.add(node1)
    }

    fun showConnections() {
        for (key in adjacentList.keys) {
            val connections = StringBuilder()
            for (vertex in adjacentList[key]!!) {
                connections.append(vertex).append(" ")
            }
            println("$key --> $connections")
        }
    }
}