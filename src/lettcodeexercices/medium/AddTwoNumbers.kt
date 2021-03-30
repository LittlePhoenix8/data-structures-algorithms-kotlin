package lettcodeexercices.medium

import lettcodeexercices.ListNode

/**
 * https://leetcode.com/problems/add-two-numbers/
 * */
fun main() {
    val addTwoNumbers = AddTwoNumbers()
    val root1 = ListNode(2)
    val node1 = ListNode(3)
    val node2 = ListNode(4)
    root1.next = node1
    node1.next = node2
    node2.next = null

    val root2 = ListNode(5)
    val node3 = ListNode(6)
    val node4 = ListNode(4)
    root2.next = node3
    node3.next = node4
    node4.next = null

    val root3 = ListNode(9)
    val node5 = ListNode(9)
    val node6 = ListNode(9)
    val node7 = ListNode(9)
    val node8 = ListNode(9)
    val node9 = ListNode(9)
    val node10 = ListNode(9)

    root3.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8
    node8.next = node9
    node9.next = node10
    node10.next = null

    val root4 = ListNode(9)
    val node11 = ListNode(9)
    val node12 = ListNode(9)
    val node13 = ListNode(9)
    root4.next = node11
    node11.next = node12
    node12.next = node13
    node13.next = null

    println(addTwoNumbers.addTwoNumbers(root1, root2)?.print()) //[7, 0, 8]
    println(addTwoNumbers.addTwoNumbers(ListNode(0), ListNode(0))?.print()) //[0]
    println(addTwoNumbers.addTwoNumbers(null, null)?.print()) //null
    println(addTwoNumbers.addTwoNumbers(root3, root4)?.print()) //[8, 9, 9, 9, 0, 0, 0, 1]
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var currentL1 = l1
        var currentL2 = l2
        var prev = ListNode(0)
        val head = prev
        var carry = 0
        while (currentL1 != null || currentL2 != null || carry != 0) {
            val current = ListNode(0)
            val sum = (currentL2?.`val` ?: 0) + (currentL1?.`val` ?: 0) + carry
            current.`val` = sum % 10
            carry = sum / 10

            prev.next = current
            prev = current

            currentL1 = if (currentL1 == null) currentL1 else currentL1.next
            currentL2 = if (currentL2 == null) currentL2 else currentL2.next
        }
        return head.next
    }
}