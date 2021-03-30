package lettcodeexercices.medium

import lettcodeexercices.easy.TreeNode

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * */
fun main() {
    val validateBinarySearchTree = ValidateBinarySearchTree()
    val root1 = TreeNode(2)
    val node1 = TreeNode(1)
    val node2 = TreeNode(3)
    root1.left = node1
    root1.right = node2

    val root2 = TreeNode(5)
    val node3 = TreeNode(1)
    val node4 = TreeNode(4)
    val node5 = TreeNode(3)
    val node6 = TreeNode(6)
    root2.left = node3
    root2.right = node3
    node4.left = node5
    node4.right = node6

    println(validateBinarySearchTree.isValidBST(root1)) //true
    println(validateBinarySearchTree.isValidBST(root2)) //false
}

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return validBts(root, null, null)
    }

    private fun validBts(node: TreeNode?, lower: Int?, upper: Int?): Boolean {
        if(node == null) {
            return true
        }
        val value = node.`val`
        if(lower != null && value <= lower) {
            return false
        }
        if(upper != null && value >= upper) {
            return false
        }
        if(!validBts(node.right, value, upper)) {
            return false
        }
        if(!validBts(node.left, lower, value)) {
            return false
        }
        return true
    }
}