package lettcodeexercices.easy

import java.util.*

/**
 * https://leetcode.com/problems/symmetric-tree/
 * */
fun main() {
    val tree = TreeNode(1)
    val node1 = TreeNode(2)
    val node2 = TreeNode(2)

    val node3 = TreeNode(3)
    val node4 = TreeNode(4)

    val node5 = TreeNode(4)
    val node6 = TreeNode(3)

    tree.left = node1
    tree.right = node2

    node1.left = node3
    node1.right = node4

    node2.left = node5
    node2.right = node6

    val tree2 = TreeNode(1)
    val treNode1 = TreeNode(2)
    val treNode2 = TreeNode(2)

    val treeNode3 = TreeNode(3)
    val treeNode4 = TreeNode(3)

    tree2.left = treNode1
    tree2.right = treNode2

    treNode1.right = treeNode3
    treNode2.right = treeNode4

    val symmetricTree = SymmetricTree()
    println(symmetricTree.isSymmetric(tree))
    println(symmetricTree.isSymmetric(tree2))

    println(symmetricTree.isSymmetricRecursive(tree))
    println(symmetricTree.isSymmetricRecursive(tree2))
}

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val stack = Stack<TreeNode?>()
        stack.push(root.left)
        stack.push(root.right)
        while (stack.isNotEmpty()) {
            val right = stack.pop()
            val left = stack.pop()
            if (left == null && right == null) {
                continue
            } else if (left == null || right == null || right.`val` != left.`val`) {
                return false
            }
            stack.push(left.left)
            stack.push(right.right)
            stack.push(left.right)
            stack.push(right.left)
        }
        return true
    }

    fun isSymmetricRecursive(root: TreeNode?): Boolean {
        return root == null || isSymmetric(root.left, root.right)
    }

    private fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) {
            return left == right
        }
        if (left.`val` != right.`val`) {
            return false
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
    }
}