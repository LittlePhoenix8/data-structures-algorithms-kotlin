package hackerrank.interviewpreparationkit.trees

import java.lang.Integer.max

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 * */
fun main() {
    val heightBinaryTree = HeightBinaryTree()

    val root1 = Node(4)
    val node1 = Node(2)
    val node2 = Node(6)
    val node3 = Node(1)
    val node4 = Node(3)
    val node5 = Node(5)
    val node6 = Node(7)
    root1.left = node1
    root1.right = node2
    node1.left = node3
    node1.right = node4
    node2.left = node5
    node2.right = node6
    println(heightBinaryTree.height(root1)) //2

    val root2 = Node(3)
    val node7 = Node(2)
    val node8 = Node(5)
    val node9 = Node(1)
    val node10 = Node(4)
    val node11 = Node(6)
    val node12 = Node(7)
    root2.left = node7
    root2.right = node8
    node7.left = node9
    node8.left = node10
    node8.right = node11
    node11.right = node12
    println(heightBinaryTree.height(root2)) //3

    val root3 = Node(3)
    val node13 = Node(2)
    val node14 = Node(5)
    val node15 = Node(1)
    val node16 = Node(4)
    val node17 = Node(6)
    val node18 = Node(7)
    root3.left = node13
    root3.right = node14
    node13.left = node15
    node14.left = node16
    node14.right = node17
    node17.right = node18
    println(heightBinaryTree.height(root3)) //3
}

class HeightBinaryTree {
    fun height(root: Node?): Int {
        if (root == null) {
            return -1
        }
        return max(height(root.left), height(root.right)) + 1
    }
}

class Node (var data: Int) {
    var left: Node? = null
    var right: Node? = null
}