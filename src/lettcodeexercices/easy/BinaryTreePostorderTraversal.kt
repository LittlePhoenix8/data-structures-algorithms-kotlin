package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * */
fun main() {
    val binaryTreePostorderTraversal = BinaryTreePostorderTraversal()
    val root1 = TreeNode(1)
    val node1 = TreeNode(2)
    val node2 = TreeNode(3)
    root1.right = node1
    node1.left = node2
    println(binaryTreePostorderTraversal.postorderTraversal(root1).joinToString(", ")) //[3, 2, 1]
    println(binaryTreePostorderTraversal.postorderTraversal(null).joinToString(", ")) //[]
    println(binaryTreePostorderTraversal.postorderTraversal(TreeNode(1)).joinToString(", ")) //[1]

    val root2 = TreeNode(1)
    val node3 = TreeNode(2)
    root2.left = node3
    println(binaryTreePostorderTraversal.postorderTraversal(root2).joinToString(", ")) //[2, 1]

    val root3 = TreeNode(1)
    val node4 = TreeNode(2)
    root3.right = node4
    println(binaryTreePostorderTraversal.postorderTraversal(root3).joinToString(", ")) //[2, 1]
}

class BinaryTreePostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) {
            return listOf()
        }
        val list = ArrayList<Int>()
        traversePostOrder(root, list)
        return list
    }

    private fun traversePostOrder(node: TreeNode, list: ArrayList<Int>) {
        if(node.left != null) {
            traversePostOrder(node.left!!, list)
        }
        if(node.right != null) {
            traversePostOrder(node.right!!, list)
        }
        list.add(node.`val`)
    }
}