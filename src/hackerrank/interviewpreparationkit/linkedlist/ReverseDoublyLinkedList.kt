package hackerrank.interviewpreparationkit.linkedlist

import java.util.*

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
 * */
fun main() {
    //1 <-> 2 <-> 3 <-> 4 <-> null
    //4 <-> 3 <-> 2 <-> 1 <-> null
    val reverseDoublyLinkedList = ReverseDoublyLinkedList()

    val head1 = DoublyLinkedListNode(1)
    val node1 = DoublyLinkedListNode(2)
    val node2 = DoublyLinkedListNode(3)
    val node3 = DoublyLinkedListNode(4)
    head1.prev = null
    head1.next = node1
    node1.prev = head1
    node1.next = node2
    node2.prev = node1
    node2.next = node3
    node3.prev = node2
    node3.next = null

    val newHead1 = reverseDoublyLinkedList.reverse(head1)
    newHead1?.printListNode()
}

class ReverseDoublyLinkedList {
    fun reverse(head: DoublyLinkedListNode?): DoublyLinkedListNode? {
        if (head == null) {
            return null
        }
        val stack = Stack<Int>()
        var node: DoublyLinkedListNode? = head
        while (node != null) {
            stack.push(node.data)
            node = node.next
        }
        if (stack.isEmpty()) {
            return null
        }
        val newHead = DoublyLinkedListNode(stack.pop())
        var currentNode: DoublyLinkedListNode? = newHead
        while (stack.isNotEmpty()) {
            val newNode = DoublyLinkedListNode(stack.pop())
            currentNode?.next = newNode
            newNode.prev = head
            currentNode = currentNode?.next
        }
        return newHead
    }
}