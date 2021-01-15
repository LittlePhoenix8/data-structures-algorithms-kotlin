package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/same-tree/
 * */
fun main() {
    val sameTree = SameTree()

    //p = [1,2,3], q = [1,2,3]
    val p1 = TreeNode(1)
    val p1Left = TreeNode(2)
    val p1Right = TreeNode(3)
    p1.left = p1Left
    p1.right = p1Right

    val q1 = TreeNode(1)
    val q1Left = TreeNode(2)
    val q1Right = TreeNode(3)
    q1.left = q1Left
    q1.right = q1Right

    println(sameTree.isSameTree(p1, q1)) //true

    //p = [1,2], q = [1,null,2]
    val p2 = TreeNode(1)
    val p2Left = TreeNode(2)
    p2.left = p2Left
    p2.right = null

    val q2 = TreeNode(1)
    val q2Right = TreeNode(2)
    q2.left = null
    q2.right = q2Right

    println(sameTree.isSameTree(p2, q2)) //false

    //p = [1,2,1], q = [1,1,2]
    val p3 = TreeNode(1)
    val p3Left = TreeNode(2)
    val p3Right = TreeNode(1)
    p3.left = p3Left
    p3.right = p3Right

    val q3 = TreeNode(1)
    val q3Left = TreeNode(1)
    val q3Right = TreeNode(2)
    q3.left = q3Left
    q3.right = q3Right

    println(sameTree.isSameTree(p3, q3)) //false


    //p = [1,null,2,3], q = [1,null,2,null,3]
    val p4 = TreeNode(1)
    val p4Right = TreeNode(2)
    val p4RightLeft = TreeNode(3)
    p4.left = null
    p4.right = p4Right
    p4Right.left = p4RightLeft
    p4Right.right = null

    val q4 = TreeNode(1)
    val q4Right = TreeNode(2)
    val q4RightRight = TreeNode(3)
    q4.left = null
    q4.right = q4Right
    q4Right.left = null
    q4Right.right = q4RightRight

    println(sameTree.isSameTree(p4, q4)) //false
}

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p == null || q == null) {
            return false
        }
        if (p.`val` != q.`val`) {
            return false
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right)
    }

    private fun isSame(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null && node2 == null) {
            return true
        }
        if (node1 == null || node2 == null) {
            return false
        }
        if (node1.`val` != node2.`val`) {
            return false
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right)
    }
}