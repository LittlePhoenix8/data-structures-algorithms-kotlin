package interviewquestion.facebook

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
*     4
*    / \
*   7   9
*  / \   \
* 10  2   6
*      \
*       6
*      /
*     2
* Out: [4, 8, 6, 6, 2]
*
* data: { 0:[4], 1:[7, 9], 2:[10, 2, 6], 3:[6], 4:[2] }
* data2: { 0:[4, 1], 1:[7 + 9, 1 + 1], 2:[10 + 2 + 6, 1 + 1 + 1], 3:[6, 1], 4:[2, 1] }
* data2: { 0:[4, 1], 1:[16, 2], 2:[18, 3], 3:[6, 1], 4:[2, 1] }
* result: [4, 8, 6, 6, 2]
*
* Time complexity: O(n)
* Space complexity: O(n)
* */
class BinaryTreeGetAverageSum {
    fun avgByDepth(root: Node?): Array<Int> {
        val data = HashMap<Int, Array<Int>>()
        getAverageSum(root, data, 0)
        val result = Array(data.size) { 0 }
        for ((i, numbers) in data.values.withIndex()) {
            result[i] = numbers[0] / numbers[1]
        }
        return result
    }

    private fun getAverageSum(node: Node?, data: HashMap<Int, Array<Int>>, depth: Int) {
        if (node == null) {
            return
        }
        if (!data.containsKey(depth)) {
            data[depth] = arrayOf(node.number, 1)
        } else {
            val count = data[depth]!!
            data[depth] = arrayOf(count[0] + node.number, count[1] + 1)
        }
        getAverageSum(node.left, data, depth + 1)
        getAverageSum(node.right, data, depth + 1)
    }

    fun avgByDepthBFS(root: Node?): Array<Int> {
        if (root == null) {
            return arrayOf()
        }
        val data = HashMap<Int, Array<Int>>()
        val result = ArrayList<Int>()
        val queue = LinkedList<Pair<Node, Int>>()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val pair = queue.remove()
            val node = pair.first
            val depth = pair.second

            if (!data.containsKey(depth)) {
                data[depth] = arrayOf(node.number, 1)
            } else {
                val count = data[depth]!!
                data[depth] = arrayOf(count[0] + node.number, count[1] + 1)
            }

            if (node.left != null) {
                queue.add(Pair(node.left!!, depth + 1))
            }
            if (node.right != null) {
                queue.add(Pair(node.right!!, depth + 1))
            }

            if (queue.peek() == null || (queue.peek() != null && queue.peek().second > depth)) {
                val numbers = data[depth]!!
                result.add(numbers[0] / numbers[1])
            }
        }

        return result.toTypedArray()
    }

    class Node(var number: Int) {
        var left: Node? = null
        var right: Node? = null
    }
}

fun main() {
    val binaryTreeGetAverageSum = BinaryTreeGetAverageSum()

    val root = BinaryTreeGetAverageSum.Node(4)
    val node1 = BinaryTreeGetAverageSum.Node(7)
    val node2 = BinaryTreeGetAverageSum.Node(9)
    val node3 = BinaryTreeGetAverageSum.Node(10)
    val node4 = BinaryTreeGetAverageSum.Node(2)
    val node5 = BinaryTreeGetAverageSum.Node(6)
    val node6 = BinaryTreeGetAverageSum.Node(6)
    val node7 = BinaryTreeGetAverageSum.Node(2)
    root.left = node1
    root.right = node2
    node1.left = node3
    node1.right = node4
    node2.right = node5
    node4.right = node6
    node6.left = node7

    println(binaryTreeGetAverageSum.avgByDepth(root).joinToString(", "))
    println(binaryTreeGetAverageSum.avgByDepthBFS(root).joinToString(", "))
}