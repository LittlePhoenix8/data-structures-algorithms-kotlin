package lettcodeexercices.easy

import lettcodeexercices.ListNode
import sun.misc.Queue
import java.util.*

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * */
fun main() {
    val head1 = ListNode(1)
    val head1Node1 = ListNode(2)
    head1.next = head1Node1
    head1Node1.next = null

    val head2 = ListNode(1)
    val head2Node1 = ListNode(2)
    val head2Node2 = ListNode(2)
    val head2Node3 = ListNode(1)
    head2.next = head2Node1
    head2Node1.next = head2Node2
    head2Node2.next = head2Node3
    head2Node3.next = null

    val palindromeLinkedList = PalindromeLinkedList()
    println(palindromeLinkedList.isPalindrome(head1)) //false
    println(palindromeLinkedList.isPalindrome(head2)) //true
}

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        val stack = Stack<Int>()
        val queue = Queue<Int>()

        var currentNode = head
        while (currentNode != null) {
            stack.push(currentNode.`val`)
            queue.enqueue(currentNode.`val`)
            currentNode = currentNode.next
        }

        while (stack.isNotEmpty() && !queue.isEmpty) {
            val last = stack.pop()
            val first = queue.dequeue()
            if (last != first) {
                return false
            }
        }
        return true
    }
}