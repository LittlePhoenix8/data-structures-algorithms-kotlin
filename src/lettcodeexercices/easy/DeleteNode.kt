package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * */
fun main() {
    val node1 = ListNode(2)
    val node2 = ListNode(0)
    val node3 = ListNode(1)
    val node4 = ListNode(3)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = null

    val deleteNode = DeleteNode()
    deleteNode.deleteNode(node1)

    println(node1.print())
}

class DeleteNode {
    fun deleteNode(node: ListNode?) {
        if (node == null) {
            return
        }
        node.`val` = node.next!!.`val`
        node.next = node.next!!.next
    }
}