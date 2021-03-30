package lettcodeexercices.hard

import lettcodeexercices.ListNode
import java.util.*

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * */
fun main() {
    val mergeKSortedLists = MergeKSortedLists()
    val root1 = ListNode(1)
    val node1 = ListNode(4)
    val node2 = ListNode(5)
    root1.next = node1
    node1.next = node2
    node2.next = null

    val root2 = ListNode(1)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    root2.next = node3
    node3.next = node4
    node4.next = null

    val root3 = ListNode(2)
    val node5 = ListNode(6)
    root3.next = node5
    node5.next = null

    println(mergeKSortedLists.mergeKLists(arrayOf(root1, root2, root3))?.print()) //[1, 1, 2, 3, 4, 4, 5, 6]
    //println(mergeKSortedLists.mergeKLists(arrayOf())) //
}

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty() || (lists.size == 1 && lists.first() == null)) {
            return null
        }
        val queue = PriorityQueue<Int>()
        for(node in lists) {
            var current: ListNode? = node
            while(current != null) {
                queue.add(current.`val`)
                current = current.next
            }
        }

        var root: ListNode? = null
        var current = root
        while(queue.isNotEmpty()) {
            val number = queue.remove()
            val newNode = ListNode(number)
            if(root == null) {
                root = newNode
                current = root
            } else {
                current!!.next = newNode
                current = newNode
            }
        }
        return root
    }
}