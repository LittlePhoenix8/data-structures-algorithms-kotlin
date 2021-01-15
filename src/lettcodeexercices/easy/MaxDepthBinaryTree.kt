package lettcodeexercices.easy

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * */
fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)

    val maxDepthBinaryTree = MaxDepthBinaryTree()
    println(maxDepthBinaryTree.maxDepth(root)) //3

    val root2 = TreeNode(3)
    root2.left = TreeNode(4)
    root2.right = TreeNode(5)
    root2.left!!.left = TreeNode(-7)
    root2.left!!.right = TreeNode(-6)

    root2.left!!.left!!.left = TreeNode(-7)
    root2.left!!.right!!.left = TreeNode(-5)
    root2.left!!.right!!.left!!.left = TreeNode(-4)

    println(maxDepthBinaryTree.maxDepth(root2)) //5
}

class MaxDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        val maxDepthLeft = if (root.left == null) 0 else maxDepth(root.left)
        val maxDepthRight = if (root.right == null) 0 else maxDepth(root.right)
        return 1 + max(maxDepthLeft, maxDepthRight)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}