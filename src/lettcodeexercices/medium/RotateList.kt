package lettcodeexercices.medium

import lettcodeexercices.easy.ListNode
/**
 * https://leetcode.com/problems/rotate-list/
 * */
fun main() {
    val rotateList = RotateList()
    val root1 = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)
    root1.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = null
    println(rotateList.rotateRight(root1, 2)?.print()) //[4, 5, 1, 2, 3]

    val root2 = ListNode(0)
    val node5 = ListNode(1)
    val node6 = ListNode(2)
    root2.next = node5
    node5.next = node6
    node6.next = null
    println(rotateList.rotateRight(root2, 4)?.print()) //[2, 0, 1]

    val root3 = ListNode(1)
    val node7 = ListNode(2)
    val node8 = ListNode(3)
    root3.next = node7
    node7.next = node8
    node8.next = null
    println(rotateList.rotateRight(root3, 2000000000)?.print()) //[2, 3, 1]
}

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }
        var tail = head
        var size = 1
        while (tail?.next != null) {
            tail = tail.next
            size++
        }
        val rotations = k % size
        if (rotations == 0) {
            return head
        }
        var newHead = head
        var prevNewHead = head
        for (i in 0 until size - rotations - 1) {
            newHead = newHead?.next
            prevNewHead = prevNewHead?.next
        }
        newHead = newHead?.next
        tail?.next = head
        prevNewHead?.next = null
        return newHead
    }
}