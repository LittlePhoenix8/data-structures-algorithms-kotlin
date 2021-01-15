package lettcodeexercices

import com.google.gson.Gson
import lettcodeexercices.easy.TreeNode

/**
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * */
fun main() {
    val traversal =  BinaryTreeFromPreorderInorderTraversal()
    val tree = traversal.buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7))
    println(Gson().toJson(tree))
}

class BinaryTreeFromPreorderInorderTraversal {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }
        //root node
        val key = preorder.first()
        val root = TreeNode(key)
        if (preorder.size == 1) {
            return root
        }
        val index = getRootIndex(inorder, key)
        if (index > 0 || index < preorder.size) {
            var pre = preorder.copyOfRange(1, index + 1)
            var inor = inorder.copyOfRange(0, index)
            root.left = buildTree(pre, inor)

            pre = preorder.copyOfRange(index + 1, preorder.size)
            inor = inorder.copyOfRange(index + 1, inorder.size)
            root.right = buildTree(pre, inor)
        }
        return root
    }

    private fun getRootIndex(inorder: IntArray, key: Int): Int {
        inorder.forEachIndexed { index, item ->
            if (item == key) {
                return index
            }
        }
        return -1
    }
}