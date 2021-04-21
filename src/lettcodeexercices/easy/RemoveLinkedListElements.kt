package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * */
fun main() {
    val removeLinkedListElements = RemoveLinkedListElements()

    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(6)
    val node4 = ListNode(3)
    val node5 = ListNode(4)
    val node6 = ListNode(5)
    val node7 = ListNode(6)
    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    println(removeLinkedListElements.removeElements(head, 6)?.print()) //1->2->3->4->5

    val head1 = ListNode(1)
    val node8 = ListNode(2)
    val node9 = ListNode(1)
    val node10 = ListNode(3)
    val node11 = ListNode(4)
    val node12 = ListNode(5)
    val node13 = ListNode(1)
    head1.next = node8
    node8.next = node9
    node9.next = node10
    node10.next = node11
    node11.next = node12
    node12.next = node13
    println(removeLinkedListElements.removeElements(head1, 1)?.print()) //2->3->4->5

    val head2 = ListNode(1)
    val node14 = ListNode(1)
    head2.next = node14
    node14.next = null
    println(removeLinkedListElements.removeElements(head2, 1)?.print()) //[]
}

class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }
        val holdNode = ListNode(0)
        holdNode.next = head
        var previousNode: ListNode? = holdNode
        while (previousNode?.next != null) {
            if (previousNode.next?.`val` == `val`){
                previousNode.next = previousNode.next?.next
            } else {
                previousNode = previousNode.next
            }
        }
        return holdNode.next
    }
}