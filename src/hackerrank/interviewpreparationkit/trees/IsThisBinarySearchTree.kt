package hackerrank.interviewpreparationkit.trees

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 * */
fun main() {
    val isThisBinarySearchTree = IsThisBinarySearchTree()

    var root1 = Node(3)
    var node1 = Node(2)
    var node2 = Node(4)
    var node3 = Node(1)
    var node4 = Node(5)
    var node5 = Node(6)
    root1.left = node1
    root1.right = node2
    node1.left = node3
    node2.left = node4
    node2.right = node5
    println(isThisBinarySearchTree.checkBST(root1)) //true

    root1 = Node(3)
    node1 = Node(2)
    node2 = Node(5)
    node3 = Node(1)
    node4 = Node(6)
    node5 = Node(1)
    root1.left = node1
    root1.right = node2
    node1.left = node3
    node2.left = node4
    node2.right = node5
    println(isThisBinarySearchTree.checkBST(root1)) //false

    val root2 = Node(4)
    val node6 = Node(2)
    val node7 = Node(6)
    val node8 = Node(1)
    val node9 = Node(3)
    val node10 = Node(5)
    val node11 = Node(7)
    root2.left = node6
    root2.right = node7
    node6.left = node8
    node6.right = node9
    node7.left = node10
    node7.right = node11
    println(isThisBinarySearchTree.checkBST(root2)) //true
}

class IsThisBinarySearchTree {
    //BST:
    //The  value of every node in a node's left subtree is less than the data value of that node.
    //The  value of every node in a node's right subtree is greater than the data value of that node.
    //The  value of every node is distinct.
    private val hashmap = HashMap<Int, Int>()

    fun checkBST(root: Node?): Boolean {
        if (root == null) {
            return true
        }
        if (root.left == null && root.right == null) {
            return false
        }
        if (!hashmap.containsKey(root.data)) {
            hashmap[root.data] = 1
        } else {
            return false
        }

        if (root.left!!.data > root.data) {
            return false
        }
        if (root.right!!.data < root.data) {
            return false
        }
        return true
    }
}