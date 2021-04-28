package lettcodeexercices.medium

import lettcodeexercices.easy.ListNode

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * */
fun main() {
    val removeNthNodeFromEndList = RemoveNthNodeFromEndList()

    val head1 = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)
    head1.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = null
    println(removeNthNodeFromEndList.removeNthFromEnd(head1, 2)?.print())

    val head2 = ListNode(1)
    println(removeNthNodeFromEndList.removeNthFromEnd(head2, 1)?.print())

    val head3 = ListNode(1)
    val node5 = ListNode(2)
    head3.next = node5
    node5.next = null
    println(removeNthNodeFromEndList.removeNthFromEnd(head3, 1)?.print())
}

class RemoveNthNodeFromEndList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var current: ListNode? = head
        var prev: ListNode? = ListNode(0)
        var newHead: ListNode? = head
        prev?.next = newHead
        var size = 0
        while (current != null) {
            size++
            current = current.next
        }
        if (n % size == 0) {
            newHead = head?.next
        } else {
            var i = 1
            val removeAt = size - n + 1
            while (prev != null) {
                if (i != removeAt) {
                    prev = prev.next
                } else {
                    prev.next = prev.next?.next
                }
                i++
            }
        }
        return newHead
    }
}