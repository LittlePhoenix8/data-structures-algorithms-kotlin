package interviewquestion.amazon

import lettcodeexercices.ListNode
import java.lang.StringBuilder

fun main() {
    val addTwoNumbers = AddTwoNumbers()

    val node1 = ListNode(2)
    val node2 = ListNode(4)
    val node3 = ListNode(3)

    node1.next = node2
    node2.next = node3
    node3.next = null

    val node4 = ListNode(5)
    val node5 = ListNode(6)
    val node6 = ListNode(4)

    node4.next = node5
    node5.next = node6
    node6.next = null

    val result1 = addTwoNumbers.addTwoNumbers(node1, node4)
    printListNode(result1) //7, 0, 8

    val nodeList1 = ListNode(9)
    val nodeList2 = ListNode(9)
    val nodeList3 = ListNode(9)
    val nodeList4 = ListNode(9)
    val nodeList5 = ListNode(9)
    val nodeList6 = ListNode(9)
    val nodeList7 = ListNode(9)

    nodeList1.next = nodeList2
    nodeList2.next = nodeList3
    nodeList3.next = nodeList4
    nodeList4.next = nodeList5
    nodeList5.next = nodeList6
    nodeList6.next = nodeList7
    nodeList7.next = null

    val nodeList8 = ListNode(9)
    val nodeList9 = ListNode(9)
    val nodeList10 = ListNode(9)
    val nodeList11 = ListNode(9)

    nodeList8.next = nodeList9
    nodeList9.next = nodeList10
    nodeList10.next = nodeList11
    nodeList11.next = null

    val result2 = addTwoNumbers.addTwoNumbers(nodeList1, nodeList8)
    printListNode(result2) //8, 9, 9, 9, 0, 0, 0, 1

    val n = ListNode(9)

    val n1 = ListNode(1)
    val n2 = ListNode(9)
    val n3 = ListNode(9)
    val n4 = ListNode(9)
    val n5 = ListNode(9)
    val n6 = ListNode(9)
    val n7 = ListNode(9)
    val n8 = ListNode(9)
    val n9 = ListNode(9)
    val n10 = ListNode(9)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    n6.next = n7
    n7.next = n8
    n8.next = n9
    n9.next = n10
    n10.next = null

    val result3 = addTwoNumbers.addTwoNumbers(n, n1)
    printListNode(result3) //0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1

    val nodeL1 = ListNode(0)
    val nodeL11 = ListNode(8)
    val nodeL12 = ListNode(6)
    val nodeL13 = ListNode(5)
    val nodeL14 = ListNode(6)
    val nodeL15 = ListNode(8)
    val nodeL16 = ListNode(3)
    val nodeL17 = ListNode(5)
    val nodeL18 = ListNode(7)

    nodeL1.next = nodeL11
    nodeL11.next = nodeL12
    nodeL12.next = nodeL13
    nodeL13.next = nodeL14
    nodeL14.next = nodeL15
    nodeL15.next = nodeL16
    nodeL16.next = nodeL17
    nodeL17.next = nodeL18
    nodeL18.next = null

    val nodeL2 = ListNode(6)
    val nodeL21 = ListNode(7)
    val nodeL22 = ListNode(8)
    val nodeL23 = ListNode(0)
    val nodeL24 = ListNode(8)
    val nodeL25 = ListNode(5)
    val nodeL26 = ListNode(8)
    val nodeL27 = ListNode(9)
    val nodeL28 = ListNode(7)

    nodeL2.next = nodeL21
    nodeL21.next = nodeL22
    nodeL22.next = nodeL23
    nodeL23.next = nodeL24
    nodeL24.next = nodeL25
    nodeL25.next = nodeL26
    nodeL26.next = nodeL27
    nodeL27.next = nodeL28
    nodeL28.next = null

    val result4 = addTwoNumbers.addTwoNumbers(nodeL1, nodeL2)
    printListNode(result4) //6, 5, 5, 6, 4, 4, 2, 5, 5, 1
}

private fun printListNode(node: ListNode?) {
    val builder = StringBuilder()
    var current = node
    while (current != null) {
        builder.append(current.`val`).append(", ")
        current = current.next
    }
    println(builder.toString())
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