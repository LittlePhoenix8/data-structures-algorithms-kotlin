package datastructures.queues

import datastructures.stacks.Node
import kotlin.collections.ArrayList

fun main(){
    val myQueue = QueueWithLinkedList()
    myQueue.enqueue("Joy")
    myQueue.enqueue("Matt")
    myQueue.enqueue("Pavel")
    myQueue.enqueue("Samir")

    myQueue.printList()

    println("Peek: ${myQueue.peek()?.value}")//Joy
    println("Dequeue: ${myQueue.dequeue()?.value}")
    myQueue.printList()

    println("Peek: ${myQueue.peek()?.value}")//Matt
    println("Dequeue: ${myQueue.dequeue()?.value}")
    myQueue.printList()

    println("Peek: ${myQueue.peek()?.value}")//Pavel
    println("Dequeue: ${myQueue.dequeue()?.value}")
    myQueue.printList()

    println("Peek: ${myQueue.peek()?.value}")//Samir
    println("Dequeue: ${myQueue.dequeue()?.value}")
    myQueue.printList()
}

class QueueWithLinkedList {
    private var first: Node? = null
    private var last: Node? = null
    private var length = 0

    fun peek(): Node? {
        return first
    }

    fun enqueue(value: String) {
        val newNode = Node(value)
        if (length == 0) {
            first = newNode
            last = newNode
        } else {
            last?.next = newNode
            last = newNode
        }
        length++
    }

    fun dequeue(): Node? {
        if (first == null) {
            return null
        }
        if (length == 1) {
            last = null
        }
        val holdingPointer = first
        first = first?.next
        length--
        return holdingPointer
    }

    fun printList() {
        val array = ArrayList<String>()
        var currentNode: Node? = first
        while (currentNode != null) {
            array.add(currentNode.value)
            currentNode = currentNode.next
        }
        println("first: $array")
        println("length: $length")
        println("last: ${last?.value}")
    }
}