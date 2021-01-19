package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * */
fun main() {
    val balancedBinaryTree = BalancedBinaryTree()
    //root = [3,9,20,null,null,15,7]
    val root1 = TreeNode(3)
    val root1Node1 = TreeNode(9)
    val root1Node2 = TreeNode(20)
    val root1Node3 = TreeNode(15)
    val root1Node4 = TreeNode(7)
    root1.left = root1Node1
    root1.right = root1Node2
    root1Node2.left = root1Node3
    root1Node2.right = root1Node4
    println(balancedBinaryTree.isBalanced(root1)) //true

    //root = [1,2,2,3,3,null,null,4,4]
    val root2 = TreeNode(1)
    val root2Node1 = TreeNode(2)
    val root2Node2 = TreeNode(2)
    val root2Node3 = TreeNode(3)
    val root2Node4 = TreeNode(3)
    val root2Node5 = TreeNode(4)
    val root2Node6 = TreeNode(4)
    root2.left = root2Node1
    root2.right = root2Node2
    root2Node1.left = root2Node3
    root2Node1.right = root2Node4
    root2Node3.left = root2Node5
    root2Node3.right = root2Node6
    println(balancedBinaryTree.isBalanced(root2)) //false

    println(balancedBinaryTree.isBalanced(null)) //true
}

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return root?.let{
            (kotlin.math.abs(getHeight(it.left) - getHeight(it.right)) <= 1) && isBalanced(it.left) && isBalanced(it.right)
        } ?: true
    }

    private fun getHeight(node: TreeNode?): Int {
        return node?.let {
            1 + kotlin.math.max(getHeight(it.left) , getHeight(it.right))
        } ?: 0
    }
}