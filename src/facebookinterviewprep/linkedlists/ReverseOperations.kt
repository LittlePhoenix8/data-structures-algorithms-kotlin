package facebookinterviewprep.linkedlists

/**
 * Reverse Operations
 * You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements,
 * bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the
 * subparts of the list are [2, 8] and [12, 16].
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list,
 * [1, 8, 2, 9, 16, 12].
 * The goal of this question is: given a resulting list, determine the original order of the elements.
 * Implementation detail:
 * You must use the following definition for elements in the linked list:
 * class Node {
 * int data;
 * Node next;
 * }
 * Signature
 * Node reverse(Node head)
 * Constraints
 * 1 <= N <= 1000, where N is the size of the list
 * 1 <= Li <= 10^9, where Li is the ith element of the list
 * Example
 * Input:
 * N = 6
 * list = [1, 2, 8, 9, 12, 16]
 * Output:
 * [1, 8, 2, 9, 16, 12]
 * */
fun main() {
    val reverseOperations = ReverseOperations()
    val head1 = reverseOperations.createLinkedList(arrayOf(1, 2, 8, 9, 12, 16))
    val expected1 = reverseOperations.createLinkedList(arrayOf(1, 8, 2, 9, 16, 12))
    val output1 = reverseOperations.reverse(head1)
    reverseOperations.check(expected1, output1)

    val head2 = reverseOperations.createLinkedList(arrayOf(2, 18, 24, 3, 5, 7, 9, 6, 12))
    val expected2 = reverseOperations.createLinkedList(arrayOf(24, 18, 2, 3, 5, 7, 9, 12, 6))
    val output2 = reverseOperations.reverse(head2)
    reverseOperations.check(expected2, output2)
}

class ReverseOperations {
    fun reverse(head: Node?): Node? {
        val elements = ArrayList<ArrayList<Int>>()
        var continous = ArrayList<Int>()
        var currentNode: Node? = head
        var currentNewNode: Node?
        //get continous pairs
        while(currentNode != null) {
            if(currentNode.data % 2 == 0) {
                continous.add(currentNode.data)
            } else {
                if(continous.size > 1) {
                    elements.add(continous)
                }
                continous = ArrayList()
            }
            currentNode = currentNode.next
        }
        if(continous.size > 1) {
            elements.add(continous)
        }
        //reorder linkedlist
        var i = 0
        var newHead: Node? = null
        currentNode = head
        currentNewNode = newHead
        while(currentNode != null) {
            if (i < elements.size && currentNode.data == elements[i].first()) {
                //first new node found on even pairs
                val reverse = elements[i]
                //reverse list of event elements
                reverse.reverse()
                i++
                var j = 0
                if (newHead == null) {
                    newHead = Node(reverse.first())
                    currentNewNode = newHead
                    currentNode = currentNode.next
                    j++
                }
                //add rest of nodes in new order
                while (j < reverse.size) {
                    val newNode = Node(reverse[j])
                    currentNewNode?.next = newNode
                    currentNewNode = currentNewNode?.next
                    currentNode = currentNode?.next
                    j++
                }
            } else {
                if (newHead == null) {
                    newHead = Node(currentNode.data)
                    currentNewNode = newHead
                } else {
                    val newNode = Node(currentNode.data)
                    currentNewNode?.next = newNode
                    currentNewNode = currentNewNode?.next
                }
                currentNode = currentNode.next
            }
        }
        return newHead
    }

    private fun printLinkedList(h: Node?) {
        var head = h
        print("[")
        while (head != null) {
            print(head.data)
            head = head.next
            if (head != null) print(" ")
        }
        print("]")
    }

    fun check(eHead: Node?, oHead: Node?) {
        var expectedHead = eHead
        var outputHead = oHead
        var result = true
        val tempExpectedHead = expectedHead
        val tempOutputHead = outputHead
        while (expectedHead != null && outputHead != null) {
            result = result and (expectedHead.data == outputHead.data)
            expectedHead = expectedHead.next
            outputHead = outputHead.next
        }
        if (!(expectedHead == null && outputHead == null)) result = false
        val rightTick = '\u2713'
        val wrongTick = '\u2717'
        if (result) {
            println("$rightTick Test")
        } else {
            print("$wrongTick Test: Expected ")
            printLinkedList(tempExpectedHead)
            print(" Your output: ")
            printLinkedList(tempOutputHead)
            println()
        }
    }

    fun createLinkedList(arr: Array<Int>): Node? {
        var head: Node? = null
        var tempHead = head
        for (v in arr) {
            if (head == null) {
                head = Node(v)
                tempHead = head
            } else {
                head.next = Node(v)
                head = head.next
            }
        }
        return tempHead
    }
}

class Node(var data: Int) {
    var next: Node? = null
}