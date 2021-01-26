package hackerrank.interviewpreparationkit.linkedlist

/**
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
 * */
fun main() {
    val detectCycle = DetectCycle()
    //1 -> 2 -> 3 -> 4 -> 5 -> 3
    val head1 = Node(1)
    val node1 = Node(2)
    val node2 = Node(3)
    val node3 = Node(4)
    val node4 = Node(5)
    head1.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2
    println(detectCycle.hasCycle(head1)) //true

    //1 -> null
    println(detectCycle.hasCycle(Node(1))) //false

    //1 -> 2 -> 3 -> 2
    val head2 = Node(1)
    val node5 = Node(2)
    val node6 = Node(3)
    head2.next = node5
    node5.next = node6
    node6.next = node5
    println(detectCycle.hasCycle(head2)) //true
}

class DetectCycle {
    fun hasCycle(head: Node?): Boolean {
        if (head == null) {
            return false
        }
        if (head.next == null) {
            return false
        }
        var slow: Node? = head
        var fast: Node? = head.next
        while (slow != fast) {
            if (fast?.next == null) {
                return false
            }
            slow = slow?.next
            fast = fast.next?.next
        }
        return true
    }
}

class Node(var data: Int) {
    var next: Node? = null
}