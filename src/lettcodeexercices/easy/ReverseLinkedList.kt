package lettcodeexercices.easy

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * */
fun main() {
    //[1,2,3,4,5]
    val node = lettcodeexercices.easy.ListNode(1)
    val node2 = lettcodeexercices.easy.ListNode(2)
    val node3 = lettcodeexercices.easy.ListNode(3)
    val node4 = lettcodeexercices.easy.ListNode(4)
    val node5 = lettcodeexercices.easy.ListNode(5)
    node4.next = node5
    node3.next = node4
    node2.next = node3
    node.next = node2

    val reverseLinkedList = lettcodeexercices.easy.ReverseLinkedList()
    val reverseNode = reverseLinkedList.reverseList(node)
    println(reverseNode?.print()) //[5, 4, 3, 2, 1]
}

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null) {
            return null
        }
        var first = head
        var second = first.next
        first.next = null

        while(second != null) {
            val temp = second.next
            second.next = first
            first = second
            second = temp
        }
        return first
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print(): String {
        val string = StringBuilder()
        var currentNode: ListNode? = this
        while (currentNode != null) {
            string.append("${currentNode.`val`} ")
            currentNode = currentNode.next
        }
        return string.toString()
    }
}