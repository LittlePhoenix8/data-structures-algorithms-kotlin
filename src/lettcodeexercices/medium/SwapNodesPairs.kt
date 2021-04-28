package lettcodeexercices.medium

import lettcodeexercices.easy.ListNode

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * */
fun main() {
    val swapNodesPairs = SwapNodesPairs()
    val head1 = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    head1.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = null
    println(swapNodesPairs.swapPairs(head1)?.print())
    println(swapNodesPairs.swapPairs(null)?.print())
    println(swapNodesPairs.swapPairs(ListNode(1))?.print())
}

class SwapNodesPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        return if (head.next != null) {
            val temp = head.next
            head.next = swapPairs(temp?.next)
            temp?.next = head
            temp
        } else {
            head
        }
    }
}