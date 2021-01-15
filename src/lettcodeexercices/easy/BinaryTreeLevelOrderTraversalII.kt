package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * */
fun main() {
    val levelOrder = BinaryTreeLevelOrderTraversalII()

    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //[3,9,20,null,null,15,7]
    val root = TreeNode(3)
    val node1 = TreeNode(9)
    val node2 = TreeNode(20)
    val node3 = TreeNode(15)
    val node4 = TreeNode(7)

    root.left = node1
    root.right = node2
    node2.left = node3
    node2.right = node4

    val list = levelOrder.levelOrderBottom(root)
    println(list.joinToString(", ")) //[ [15,7], [9,20], [3] ]

    //[1,2]
    val root1 = TreeNode(1)
    val node11 = TreeNode(2)
    root1.left = node11
    val list1 = levelOrder.levelOrderBottom(root1)
    println(list1.joinToString(", ")) //[[2],[1]]

    //[1,2,3,4,5]
    val root2 = TreeNode(1)
    val node2Left = TreeNode(2)
    val node2Right = TreeNode(3)
    val nodeLeftLeft = TreeNode(4)
    val nodeLeftRight = TreeNode(5)
    root2.left = node2Left
    root2.right = node2Right
    node2Left.left = nodeLeftLeft
    node2Left.right = nodeLeftRight
    val list2 = levelOrder.levelOrderBottom(root2)
    println(list2.joinToString(", ")) //[[4,5],[2,3],[1]]
}

class BinaryTreeLevelOrderTraversalII {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        dfs(res, root, 0)
        return res.reversed()
    }

    private fun dfs(list: MutableList<MutableList<Int>>, root: TreeNode?, level: Int) {
        root?.let {
            if (level >= list.size) {
                list.add(level, mutableListOf())
            }
            dfs(list, it.left, level + 1)
            dfs(list, it.right, level + 1)
            list[level].add(it.`val`)
        }
    }
}