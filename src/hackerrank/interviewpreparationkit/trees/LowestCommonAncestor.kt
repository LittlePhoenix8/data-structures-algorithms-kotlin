package hackerrank.interviewpreparationkit.trees

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
 * */
fun main() {
    val lowestCommonAncestor = LowestCommonAncestor()

    val root1 = Node(4)
    val node1 = Node(2)
    val node2 = Node(3)
    val node3 = Node(1)
    val node4 = Node(7)
    val node5 = Node(6)
    root1.left = node1
    root1.right = node4
    node1.left = node3
    node1.right = node2
    node4.left = node5

    println(lowestCommonAncestor.lca(root1, 1, 7)?.data) //4
}

class LowestCommonAncestor {
    fun lca(root: Node?, v1: Int, v2: Int): Node? {
        if (root == null) {
            return null
        }
        if (root.data > v1 && root.data > v2) {
            //both to the left
            return lca(root.left, v1, v2)
        }
        if (root.data < v1 && root.data < v2) {
            //both to te right
            return lca(root.right, v1, v2)
        }
        return root
    }
}