package interviewquestion.dailycodingproblem.january2021

/**
 * This problem was asked by Google.
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
 * For example, given the following preorder traversal:
 * [a, b, d, e, c, f, g]
 * And the following inorder traversal:
 * [d, b, e, a, f, c, g]
 * You should return the following tree:
 *                a
 *               / \
 *              b   c
 *             / \ / \
 *            d  e f  g
 * */
fun main() {
    val node2 = Node6("d")
    val node3 = Node6("e")
    val node1 = Node6("b", node2, node3)

    val node5 = Node6("f")
    val node6 = Node6("g")
    val node4 = Node6("c", node5, node6)

    val root = Node6("a", node1, node4)
    val listPreOrder = ArrayList<String?>()
    val listInOrder = ArrayList<String?>()
    println("traverse pre order: ${traversePreOrder(root, listPreOrder)}")
    println("traverse in order: ${traverseInOrder(root, listInOrder)}")

    val preOrderArray = arrayOf("a", "b", "d", "e", "c", "f", "g")
    val inOrderArray = arrayOf("d", "b", "e", "a", "f", "c", "g")
    listPreOrder.clear()
    listInOrder.clear()
    val newNode = getNodeFromArrays(preOrderArray, inOrderArray)
    println("new node pre order: ${traversePreOrder(newNode, listPreOrder)}")
    println("new node in order: ${traverseInOrder(newNode, listInOrder)}")
}

fun getNodeFromArrays(preOrder: Array<String>, inOrder: Array<String>): Node6? {
    if (preOrder.isEmpty() || inOrder.isEmpty()) {
        return null
    }
    val key = preOrder.first()
    val root = Node6(key)
    if (preOrder.size == 1) {
        return root
    }
    val index = getRootIndex(inOrder, key)
    if (index > 0 || index < preOrder.size) {
        var newPreOrder = preOrder.copyOfRange(1, index + 1)
        var newInOrder = inOrder.copyOfRange(0, index + 1)
        root.left = getNodeFromArrays(newPreOrder, newInOrder)

        newPreOrder = preOrder.copyOfRange(index + 1, preOrder.size)
        newInOrder = inOrder.copyOfRange(index + 1, inOrder.size)
        root.right = getNodeFromArrays(newPreOrder, newInOrder)
    }
    return root
}

private fun getRootIndex(inorder: Array<String>, key: String): Int {
    inorder.forEachIndexed { index, item ->
        if (item == key) {
            return index
        }
    }
    return -1
}

private fun traversePreOrder(node: Node6?, list: ArrayList<String?>): ArrayList<String?> {
    list.add(node?.value)
    if (node?.left != null) {
        traversePreOrder(node.left, list)
    }
    if (node?.right != null) {
        traversePreOrder(node.right, list)
    }
    return list
}

private fun traverseInOrder(node: Node6?, list: ArrayList<String?>): ArrayList<String?> {
    if (node?.left != null) {
        traverseInOrder(node.left, list)
    }
    list.add(node?.value)
    if (node?.right != null) {
        traverseInOrder(node.right, list)
    }
    return list
}

class Node6(var value: String?, var left: Node6?, var right: Node6?) {
    constructor(value: String?): this(value, null, null)
}