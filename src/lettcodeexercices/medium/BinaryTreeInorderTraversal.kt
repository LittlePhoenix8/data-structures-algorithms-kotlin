package lettcodeexercices.medium

import lettcodeexercices.easy.TreeNode

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * */
fun main() {
    val inOrder = BinaryTreeInorderTraversal()

    val root1 = TreeNode(1)
    val node1 = TreeNode(2)
    val node2 = TreeNode(3)
    root1.right = node1
    node1.left = node2
    println(inOrder.inorderTraversal(root1).joinToString(",")) //[1, 3, 2]

    val root2 = TreeNode(1)
    println(inOrder.inorderTraversal(root2).joinToString(",")) //[1]

    val root3 = TreeNode(1)
    val node3 = TreeNode(2)
    root3.left = node3
    println(inOrder.inorderTraversal(root3).joinToString(",")) //[2, 1]

    val root4 = TreeNode(1)
    val node4 = TreeNode(2)
    root4.right = node4
    println(inOrder.inorderTraversal(root4).joinToString(",")) //[1, 2]
}

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        if (root == null) {
            return list
        }
        if (root.left == null && root.right == null) {
            list.add(root.`val`)
            return list
        }
        return inOrder(root, list)
    }

    private fun inOrder(node: TreeNode?, list: ArrayList<Int>): List<Int> {
        if (node?.left != null) {
            inOrder(node.left, list)
        }
        node?.let {
            list.add(it.`val`)
        }
        if (node?.right != null) {
            inOrder(node.right, list)
        }
        return list
    }
}