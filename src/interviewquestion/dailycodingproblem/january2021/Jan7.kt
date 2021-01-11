package interviewquestion.dailycodingproblem.january2021

/**
 * This problem was asked by Microsoft.
 * Suppose an arithmetic expression is given as a binary tree.
 * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 * Given the root to such a tree, write a function to evaluate it.
 * For example, given the following tree:
 *            *
 *           / \
 *         +    +
 *        / \  / \
 *       3  2  4  5
 * You should return 45, as it is (3 + 2) * (4 + 5).
 * */
fun main() {
    val node1 = ArithmeticNode(3)
    val node2 = ArithmeticNode(2)
    val node3 = ArithmeticNode(4)
    val node4 = ArithmeticNode(5)

    val nodePlus1 = ArithmeticNode('+', node1, node2)
    val nodePlus2 = ArithmeticNode('+', node3, node4)

    val root = ArithmeticNode('*', nodePlus1, nodePlus2)
    println(solvedArithmeticTree(root))
}

fun solvedArithmeticTree(root: ArithmeticNode): Int {
    //DFS
    val list1 = ArrayList<Any?>()
    traversePostOrder(root, list1)
    println(list1.joinToString(", "))

    val res = ArrayList<Int>()
    val sum = ArrayList<Int>()
    var result = 0

    for (value in list1) {
        when (value) {
            is Int -> {
                sum.add(value)
            }
            '+' -> {
                res.add(sum.sum())
                sum.clear()
            }
            '*' -> {
                result = res.fold(1, { total, next -> total * next })
            }
        }
    }
    return result
}

private fun traversePostOrder(node: ArithmeticNode?, list: ArrayList<Any?>): ArrayList<Any?> {
    if (node?.left != null) {
        traversePostOrder(node.left, list)
    }
    if (node?.right != null) {
        traversePostOrder(node.right, list)
    }
    list.add(node?.value)
    return list
}

class ArithmeticNode(var value: Any, var left: ArithmeticNode?, var right: ArithmeticNode?) {
    constructor(value: Any): this(value, null, null)
}