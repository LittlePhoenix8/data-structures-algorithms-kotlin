package hackerrank.interviewpreparationkit.linkedlist

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 * */
fun main() {
    //1 <-> 2 <-> 4 <-> null
    //3
    //1 <-> 2 <-> 3 <-> 4 <-> null
    val insertIntoSortedDoublyLinkedList = InsertIntoSortedDoublyLinkedList()
    val head = DoublyLinkedListNode(1)
    val node1 = DoublyLinkedListNode(2)
    val node2 = DoublyLinkedListNode(4)
    head.prev = null
    head.next = node1
    node1.prev = head
    node1.next = node2
    node2.prev = node1
    node2.next = null

    val newHead = insertIntoSortedDoublyLinkedList.sortedInsert(head, 3)
    newHead.printListNode()

    //1 <-> 2 <-> 3 <-> 4 <-> null
    //5
    //1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
    val newHead2 = insertIntoSortedDoublyLinkedList.sortedInsert(newHead, 5)
    newHead2.printListNode()

    //1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
    //0
    //0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
    val newHead3 = insertIntoSortedDoublyLinkedList.sortedInsert(newHead2, 0)
    newHead3.printListNode()

    //0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
    //2
    //0 <-> 1 <-> 2 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
    val newHead4 = insertIntoSortedDoublyLinkedList.sortedInsert(newHead3, 2)
    newHead4.printListNode()

    //null
    //1
    //1 <-> null
    val newHead5 = insertIntoSortedDoublyLinkedList.sortedInsert(null, 1)
    newHead5.printListNode()

    println("recursive")

    val headR = DoublyLinkedListNode(1)
    val node1R = DoublyLinkedListNode(2)
    val node2R = DoublyLinkedListNode(4)
    headR.prev = null
    headR.next = node1R
    node1R.prev = headR
    node1R.next = node2R
    node2R.prev = node1R
    node2R.next = null

    val newHeadR = insertIntoSortedDoublyLinkedList.sortedInsertRecursive(headR, 3)
    newHeadR.printListNode()

    val newHead2R = insertIntoSortedDoublyLinkedList.sortedInsertRecursive(newHeadR, 5)
    newHead2R.printListNode()

    val newHead3R = insertIntoSortedDoublyLinkedList.sortedInsertRecursive(newHead2R, 0)
    newHead3R.printListNode()

    val newHead4R = insertIntoSortedDoublyLinkedList.sortedInsertRecursive(newHead3R, 2)
    newHead4R.printListNode()

    val newHead5R = insertIntoSortedDoublyLinkedList.sortedInsertRecursive(null, 1)
    newHead5R.printListNode()

}

class InsertIntoSortedDoublyLinkedList {
    fun sortedInsert(head: DoublyLinkedListNode?, data: Int): DoublyLinkedListNode {
        if (head == null) {
            return DoublyLinkedListNode(data)
        }
        val newNode = DoublyLinkedListNode(data)
        var currentNode: DoublyLinkedListNode? = head
        if (currentNode!!.data > data) {
            val temp = currentNode
            currentNode = newNode
            newNode.prev = null
            newNode.next = temp
            temp.prev = newNode
            return currentNode
        }
        while (currentNode != null) {
            if (currentNode.next != null) {
                if (currentNode.data < data && data < currentNode.next!!.data) {
                    val temp = currentNode.next
                    temp!!.prev = newNode
                    newNode.prev = currentNode
                    currentNode.next = newNode
                    newNode.next = temp
                    break
                } else if (currentNode.data == data) {
                    val temp = currentNode.next
                    currentNode.next = newNode
                    newNode.prev = currentNode
                    newNode.next = temp
                    temp!!.prev = newNode
                    break
                }
            } else {
               if (data > currentNode.data) {
                   currentNode.next = newNode
                   newNode.prev = currentNode
                   newNode.next = null
                   break
               } else {
                   val temp = currentNode
                   currentNode = newNode
                   newNode.prev = temp.prev
                   newNode.next = temp
                   temp.prev = newNode
                   temp.next = null
                   break
               }
            }
            currentNode = currentNode.next
        }
        return head
    }

    fun sortedInsertRecursive(head: DoublyLinkedListNode?, data: Int): DoublyLinkedListNode {
        val newNode = DoublyLinkedListNode(data)
        return when {
            head == null -> {
                newNode
            }
            data <= head.data -> {
                newNode.next = head
                head.prev = newNode
                newNode
            }
            else -> {
                val temp = sortedInsertRecursive(head.next, data)
                head.next = temp
                temp.prev = head
                head
            }
        }
    }
}

class DoublyLinkedListNode(var data: Int) {
    var next: DoublyLinkedListNode? = null
    var prev: DoublyLinkedListNode? = null

    fun printListNode() {
        var currentNode: DoublyLinkedListNode? = this
        while (currentNode != null) {
            print("${currentNode.data} <-> ")
            currentNode = currentNode.next
        }
        print("null")
        println()
    }
}