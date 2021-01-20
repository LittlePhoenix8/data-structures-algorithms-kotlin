package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/path-sum/
 * */
fun main() {
    val pathSum = PathSum()

    //      5
    //     / \
    //    4   8
    //   /   / \
    //  11  13  4
    // /  \      \
    //7    2      1
    //sum = 22
    val root1 = TreeNode(5)
    val root1Left = TreeNode(4)
    val root1Right = TreeNode(8)
    val root1LeftLeft = TreeNode(11)
    val root1LeftLeftLeft = TreeNode(7)
    val root1LeftLeftRight = TreeNode(2)
    val root1RightLeft = TreeNode(13)
    val root1RightRight = TreeNode(4)
    val root1RightRightRight = TreeNode(1)

    root1.left = root1Left
    root1.right = root1Right
    root1Left.left = root1LeftLeft
    root1LeftLeft.left = root1LeftLeftLeft
    root1LeftLeft.right = root1LeftLeftRight
    root1Right.left = root1RightLeft
    root1Right.right = root1RightRight
    root1RightRight.right = root1RightRightRight

    println(pathSum.hasPathSum(root1, 22)) //true
}

class PathSum {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        return root?.let {
            if (it.left == null && it.right == null) {
                return it.`val` == sum
            }
            return hasPathSum(it.left, sum - it.`val`) || hasPathSum(it.right, sum - it.`val`)
        } ?: false
    }
}