package lettcodeexercices.easy

import lettcodeexercices.ListNode

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * */
fun main() {
    val head1 = ListNode(3)
    val head1Node1 = ListNode(2)
    val head1Node2 = ListNode(0)
    val head1Node3 = ListNode(4)
    head1.next = head1Node1
    head1Node1.next = head1Node2
    head1Node2.next = head1Node3
    head1Node3.next = head1Node1

    val head2 = ListNode(1)
    head2.next = null

    val head3 = ListNode(-21)
    val head3Node1 = ListNode(10)
    val head3Node2 = ListNode(17)
    val head3Node3 = ListNode(8)
    val head3Node4 = ListNode(4)
    val head3Node5 = ListNode(26)
    val head3Node6 = ListNode(5)
    val head3Node7 = ListNode(35)
    val head3Node8 = ListNode(33)
    val head3Node9 = ListNode(-7)
    val head3Node10 = ListNode(-16)
    val head3Node11 = ListNode(27)
    val head3Node12 = ListNode(-12)
    val head3Node13 = ListNode(29)
    val head3Node14 = ListNode(-12)
    val head3Node15 = ListNode(5)
    val head3Node16 = ListNode(9)
    val head3Node17 = ListNode(20)
    val head3Node18 = ListNode(14)
    val head3Node19 = ListNode(14)
    val head3Node20 = ListNode(2)
    val head3Node21 = ListNode(13)
    val head3Node22 = ListNode(-24)
    val head3Node23 = ListNode(21)
    val head3Node24 = ListNode(23)
    val head3Node25 = ListNode(-21)
    val head3Node26 = ListNode(5)

    head3.next = head3Node1
    head3Node1.next = head3Node2
    head3Node2.next = head3Node3
    head3Node3.next = head3Node4
    head3Node4.next = head3Node5
    head3Node5.next = head3Node6
    head3Node6.next = head3Node7
    head3Node7.next = head3Node8
    head3Node8.next = head3Node9
    head3Node9.next = head3Node10
    head3Node10.next = head3Node11
    head3Node11.next = head3Node12
    head3Node12.next = head3Node13
    head3Node13.next = head3Node14
    head3Node14.next = head3Node15
    head3Node15.next = head3Node16
    head3Node16.next = head3Node17
    head3Node17.next = head3Node18
    head3Node18.next = head3Node19
    head3Node19.next = head3Node20
    head3Node20.next = head3Node21
    head3Node21.next = head3Node22
    head3Node22.next = head3Node23
    head3Node23.next = head3Node24
    head3Node24.next = head3Node25
    head3Node25.next = head3Node26
    head3Node26.next = null


    val linkedListCycle = LinkedListCycle()
    println(linkedListCycle.hasCycle(head1)) //true
    println(linkedListCycle.hasCycle(head2)) //false
    println(linkedListCycle.hasCycle(head3)) //false
}

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        val hashmap = HashMap<Int, ListNode>()
        var currentNode = head
        while (currentNode != null) {
            if (hashmap.containsValue(currentNode)) {
                return true
            } else {
                hashmap[currentNode.`val`] = currentNode
            }
            currentNode = currentNode.next
        }
        return false
    }
}