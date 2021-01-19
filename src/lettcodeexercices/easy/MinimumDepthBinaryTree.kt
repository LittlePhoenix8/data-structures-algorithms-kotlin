package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * */
fun main() {
    val minimumDepthBinaryTree = MinimumDepthBinaryTree()

    //root = [3,9,20,null,null,15,7]
    val root1 = TreeNode(3)
    val root1Node1Left = TreeNode(9)
    val root1Node1Right = TreeNode(20)
    val root1Node2Left = TreeNode(15)
    val root1Node2Right = TreeNode(7)
    root1.left = root1Node1Left
    root1.right = root1Node1Right
    root1Node1Right.left = root1Node2Left
    root1Node1Right.right = root1Node2Right
    println(minimumDepthBinaryTree.minDepth(root1)) //2

    //root = [2,null,3,null,4,null,5,null,6]
    val root2 = TreeNode(2)
    val root2Node1Right = TreeNode(3)
    val root2Node2Right = TreeNode(4)
    val root2Node3Right = TreeNode(5)
    val root2Node4Right = TreeNode(6)
    root2.right = root2Node1Right
    root2Node1Right.right = root2Node2Right
    root2Node2Right.right = root2Node3Right
    root2Node3Right.right = root2Node4Right
    println(minimumDepthBinaryTree.minDepth(root2)) //5
}

class MinimumDepthBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        return when {
            root.left == null -> {
                1 + minDepth(root.right)
            }
            root.right == null -> {
                1 + minDepth(root.left)
            }
            else -> {
                1 + kotlin.math.min(minDepth(root.left), minDepth(root.right))
            }
        }
    }
}