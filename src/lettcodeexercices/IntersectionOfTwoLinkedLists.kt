package lettcodeexercices

fun main() {
    val nodeHeadA = ListNode(4)
    val nodeHeadA1 = ListNode(1)
    val nodeHeadA2 = ListNode(8)
    val nodeHead3 = ListNode(4)
    val nodeHeadA4 = ListNode(5)

    val nodeHeadB = ListNode(5)
    val nodeHeadB1 = ListNode(6)
    val nodeHeadB2 = ListNode(1)

    nodeHeadA.next = nodeHeadA1
    nodeHeadA1.next = nodeHeadA2
    nodeHeadA2.next = nodeHead3
    nodeHead3.next = nodeHeadA4
    nodeHeadA4.next = null

    nodeHeadB.next = nodeHeadB1
    nodeHeadB1.next = nodeHeadB2
    nodeHeadB2.next = nodeHeadA2

    val intersectionOfTwoLinkedLists = IntersectionOfTwoLinkedLists()
    println(intersectionOfTwoLinkedLists.getIntersectionNode(nodeHeadA, nodeHeadB)?.`val`)
}

class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var nodeA = headA
        var nodeB = headB
        while(nodeA != null) {
            while(nodeB != null) {
                if(nodeA == nodeB) {
                    return nodeA
                } else if(nodeA.next != null && nodeB.next != null && nodeA.next == nodeB.next) {
                    return nodeA.next
                }
                nodeB = nodeB.next
            }
            nodeA = nodeA.next
            nodeB = headB
        }
        return null
    }
}