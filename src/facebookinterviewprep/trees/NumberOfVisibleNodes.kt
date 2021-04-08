package facebookinterviewprep.trees

import java.util.*

/**
 * Number of Visible Nodes
 * There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes at each level. Return the number of visible nodes.
 * Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at a level could be a right node.
 * Signature
 * int visibleNodes(Node root) {
 * Input
 * The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000
 * Output
 * An int representing the number of visible nodes.
 * Example
 *        8  <------ root
 *       / \
 *     3    10
 *    / \     \
 *   1   6     14
 *  / \       /
 * 4   7     13
 * output = 4
 * */
fun main() {
    val numberOfVisibleNodes = NumberOfVisibleNodes()
    val root1 = Node(8)
    root1.left = Node(3)
    root1.right = Node(10)
    root1.left?.left = Node(1)
    root1.left?.right = Node(6)
    root1.right?.right = Node(14)
    root1.left?.right?.left = Node(4)
    root1.left?.right?.right = Node(7)
    root1.right?.right?.left = Node(13)
    val expected1 = 4
    val output1: Int = numberOfVisibleNodes.visibleNodes(root1)
    check(expected1, output1)

    val root11 = Node(8)
    root11.left = Node(3)
    root11.right = Node(10)
    root11.left?.left = Node(1)
    root11.left?.right = Node(6)
    root11.right?.right = Node(14)
    root11.left?.right?.left = Node(4)
    root11.left?.right?.right = Node(7)
    root11.right?.right?.left = Node(13)
    val expected11 = 4
    val output11: Int = numberOfVisibleNodes.visibleNodes(root11)
    check(expected11, output11)

    val root2 = Node(10)
    root2.left = Node(8)
    root2.right = Node(15)
    root2.left?.left = Node(4)
    root2.left?.left?.right = Node(5)
    root2.left?.left?.right?.right = Node(6)
    root2.right?.left = Node(14)
    root2.right?.right = Node(16)

    val expected2 = 5
    val output2: Int = numberOfVisibleNodes.visibleNodes(root2)
    check(expected2, output2)
}

var test_case_number = 1
fun check(expected: Int, output: Int) {
    val result = expected == output
    val rightTick = '\u2713'
    val wrongTick = '\u2717'
    if (result) {
        println("$rightTick Test #$test_case_number")
    } else {
        print("$wrongTick Test #$test_case_number: Expected ")
        printInteger(expected)
        print(" Your output: ")
        printInteger(output)
        println()
    }
    test_case_number++
}

fun printInteger(n: Int) {
    print("[$n]")
}

class NumberOfVisibleNodes {
    fun visibleNodes(root: Node?): Int {
        if (root == null) {
            return 0
        }
        var result = 0
        val queue = LinkedList<Node>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val n = queue.size
            for (i in 0 until n) {
                val node = queue.pop()
                if (i == 0) {
                    result++
                }
                if (node.left != null) {
                    queue.add(node.left!!)
                }
                if (node.right != null) {
                    queue.add(node.right!!)
                }
            }
        }
        return result
    }
}

class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}