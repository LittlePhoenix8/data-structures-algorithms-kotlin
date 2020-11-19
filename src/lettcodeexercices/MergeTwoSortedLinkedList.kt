package lettcodeexercices

import com.google.gson.Gson

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = null

    val node4 = ListNode(1)
    val node5 = ListNode(3)
    val node6 = ListNode(4)
    node4.next = node5
    node5.next = node6
    node6.next = null

    val mergeTwoSortedLinkedList = MergeTwoSortedLinkedList()
    val result = mergeTwoSortedLinkedList.mergeTwoLists(node1, node4)
    println(Gson().toJson(result))
}

class MergeTwoSortedLinkedList {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null && l2 == null) {
            return null
        }
        if(l1 == null) {
            return l2
        }
        if(l2 == null) {
            return l1
        }
        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}