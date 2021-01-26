package hackerrank.interviewpreparationkit.linkedlist

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 * */
fun main() {
    val findMergePointOfTwoLists = FindMergePointOfTwoLists()
    // 1
    //  \
    //   2--->3--->NULL
    //  /
    // 1
    val head1 = SinglyLinkedListNode(1)
    val head2 = SinglyLinkedListNode(1)
    val node1 = SinglyLinkedListNode(2)
    val node2 = SinglyLinkedListNode(3)
    head1.next = node1
    head2.next = node1
    node1.next = node2
    node2.next = null
    println(findMergePointOfTwoLists.findMergeNode(head1, head2)) //2

    // 1--->2
    //       \
    //        3--->Null
    //       /
    //      1
    val head3 = SinglyLinkedListNode(1)
    val head4 = SinglyLinkedListNode(1)
    val node3 = SinglyLinkedListNode(2)
    val node4 = SinglyLinkedListNode(3)
    head3.next = node3
    node3.next = node4
    node4.next = null
    head4.next = node4
    println(findMergePointOfTwoLists.findMergeNode(head3, head4)) //3
}

class FindMergePointOfTwoLists {
    fun findMergeNode(head1: SinglyLinkedListNode, head2: SinglyLinkedListNode): Int {
        var node1: SinglyLinkedListNode? = head1
        var node2: SinglyLinkedListNode? = head2
        while (node1 != null) {
            while (node2 != null) {
                if (node1 == node2) {
                    return node1.data
                }
                node2 = node2.next
            }
            node1 = node1.next
            node2 = head2
        }
        return 0
    }
}