package lettcodeexercices.easy

import com.google.gson.Gson

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * */
fun main() {
    val convertSortedArrayToBST = ConvertSortedArrayToBST()
    val tree = convertSortedArrayToBST.sortedArrayToBST(intArrayOf(-10,-3,0,5,9))
    println(Gson().toJson(tree))

    val tree1 = convertSortedArrayToBST.sortedArrayToBST(intArrayOf(0,1,2,3,4,5))
    println(Gson().toJson(tree1))
}

class ConvertSortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        return bstHelper(nums, 0, nums.size - 1)
    }

    private fun bstHelper(nums: IntArray, low: Int, high: Int): TreeNode? {
        if (low > high) {
            return null
        }
        val middle = (low + high) / 2
        val node = TreeNode(nums[middle])
        node.left = bstHelper(nums, low, middle - 1)
        node.right = bstHelper(nums, middle + 1, high)
        return node
    }
}