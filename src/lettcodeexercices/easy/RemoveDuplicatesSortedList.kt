package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * */
fun main() {
    val removeDuplicates = RemoveDuplicatesSortedList()

    val head = ListNode(1)
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    head.next = node1
    node1.next = node2
    node2.next = null
    val newNode1 = removeDuplicates.deleteDuplicates(head)
    println(newNode1?.print()) //1,2

    //1,1,2,3,3
    val head1 = ListNode(1)
    val node3 = ListNode(1)
    val node4 = ListNode(2)
    val node5 = ListNode(3)
    val node6 = ListNode(3)
    head1.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = null
    val newNode2 = removeDuplicates.deleteDuplicates(head1)
    println(newNode2?.print()) //1,2,3
}

class RemoveDuplicatesSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val hashmap = HashMap<Int, Boolean>()
        var newHead: ListNode? = null
        var currentNode: ListNode? = head
        var currentNewNode = newHead
        while (currentNode != null) {
            if (!hashmap.containsKey(currentNode.`val`)) {
                hashmap[currentNode.`val`] = true
                if (newHead == null) {
                    newHead = ListNode(currentNode.`val`)
                    currentNewNode = newHead
                } else {
                    val newNode = ListNode(currentNode.`val`)
                    currentNewNode?.next = newNode
                    currentNewNode = currentNewNode?.next
                }
            }
            currentNode = currentNode.next
        }
        return newHead
    }
}