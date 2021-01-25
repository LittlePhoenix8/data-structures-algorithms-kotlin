package hackerrank.interviewpreparationkit.linkedlist

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
 * */
fun main() {
    val insertNodeAtPosition = InsertNodeAtPosition()

    val head = SinglyLinkedListNode(16)
    val node1 = SinglyLinkedListNode(13)
    val node2 = SinglyLinkedListNode(7)

    head.next = node1
    node1.next = node2
    node2.next = null

    val newHead = insertNodeAtPosition.insertNodeAtPosition(head, 1, 2)
    var currentNode: SinglyLinkedListNode? = newHead
    while (currentNode != null) {
        print("${currentNode.data} -> ")
        currentNode = currentNode.next
    }
    //16 -> 13 -> 1 -> 7 -> null
}

class InsertNodeAtPosition {
    fun insertNodeAtPosition(llist: SinglyLinkedListNode?, data: Int, position: Int): SinglyLinkedListNode? {
        if (llist == null) {
            return null
        }
        val newNode = SinglyLinkedListNode(data)
        val holdNode = SinglyLinkedListNode(0)
        holdNode.next = llist
        var currentNode: SinglyLinkedListNode? = holdNode
        var count = 0
        while(currentNode != null) {
            if(count == position) {
                newNode.next = currentNode.next
                currentNode.next = newNode
                break
            }
            count++
            currentNode = currentNode.next
        }
        return llist
    }
}

class SinglyLinkedListNode(var data: Int) {
    var next: SinglyLinkedListNode? = null
}