package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * */
fun main() {
    val binaryTreePreorderTraversal = BinaryTreePreorderTraversal()
    val root1 = TreeNode(1)
    val node1 = TreeNode(2)
    val node2 = TreeNode(3)
    root1.right = node1
    node1.left = node2
    println(binaryTreePreorderTraversal.preorderTraversal(root1).joinToString(", ")) //[1, 2, 3]
    println(binaryTreePreorderTraversal.preorderTraversal(null).joinToString(", ")) //[]
    println(binaryTreePreorderTraversal.preorderTraversal(TreeNode(1)).joinToString(", ")) //[1]

    val root2 = TreeNode(1)
    val node3 = TreeNode(2)
    root2.left = node3
    println(binaryTreePreorderTraversal.preorderTraversal(root2).joinToString(", ")) //[1, 2]

    val root3 = TreeNode(1)
    val node4 = TreeNode(2)
    root3.right = node4
    println(binaryTreePreorderTraversal.preorderTraversal(root3).joinToString(", ")) //[1, 2]
}

class BinaryTreePreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) {
            return listOf()
        }
        val list = ArrayList<Int>()
        traversePreOrder(root, list)
        return list
    }

    private fun traversePreOrder(node: TreeNode, list: ArrayList<Int>) {
        list.add(node.`val`)
        if(node.left != null) {
            traversePreOrder(node.left!!, list)
        }
        if(node.right != null) {
            traversePreOrder(node.right!!, list)
        }
    }
}