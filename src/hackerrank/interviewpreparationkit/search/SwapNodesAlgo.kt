package hackerrank.interviewpreparationkit.search

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 * */
fun main() {
    val swapNodesAlgo = SwapNodesAlgo()
    swapNodesAlgo.swapNodes(arrayOf(arrayOf(2, 3), arrayOf(-1, -1), arrayOf(-1, -1)), arrayOf(1, 1)).forEach { println(it.joinToString(", ")) }
}

class SwapNodesAlgo {
    private val nodes = arrayListOf(Node(1, 1))

    fun swapNodes(indexes: Array<Array<Int>>, queries: Array<Int>): Array<Array<Int>> {
        val response = ArrayList<Array<Int>>()
        for (i in indexes.indices) {
            createNode(indexes[i].first(), nodes[i], "left")
            createNode(indexes[i].last(), nodes[i], "right")
        }
        for (j in queries.indices) {
            val jump = queries[j]
            for (k in nodes.indices) {
                val node = nodes[k]
                if (node.depth % jump == 0) {
                    swapNode(k)
                }
            }
            response.add(inOrder(nodes.first(), arrayListOf()))
        }
        return response.toTypedArray()
    }

    private fun createNode(value: Int, root: Node, position: String) {
        if (value > -1) {
            val depth = root.depth + 1
            val newNode = Node(value, depth)
            if (position == "left") {
                root.left = newNode
            } else {
                root.right = newNode
            }
            nodes.add(newNode)
        }
    }

    private fun swapNode(position: Int) {
        val temp = nodes[position].left
        nodes[position].left = nodes[position].right
        nodes[position].right = temp
    }

    private fun inOrder(root: Node?, result: ArrayList<Int>): Array<Int> {
        if (root !== null) {
            inOrder(root.left, result)
            result.add(root.data)
            inOrder(root.right, result)
        }
        return result.toTypedArray()
    }

    class Node(var data: Int, var depth: Int) {
        var left: Node? = null
        var right: Node? = null
    }
}