package datastructures.stacks

fun main() {
    val myStack = StackWithLinkedList()
    myStack.push("google")
    myStack.push("Udemy")
    myStack.push("Discord")

    myStack.printList()

    println("Peek: ${myStack.peek()?.value}")//discord
    println("Pop: ${myStack.pop()}")
    println("Peek: ${myStack.peek()?.value}")//udemy
    println("Pop: ${myStack.pop()}")
    println("Peek: ${myStack.peek()?.value}")//google
    println("Pop: ${myStack.pop()}")
    println("Peek: ${myStack.peek()?.value}")//null

    myStack.printList()
}

class StackWithLinkedList {
    private var top: Node? = null
    private var bottom: Node? = null
    private var length = 0

    fun peek(): Node? {
        return top
    }

    fun push(value: String) {
        val newNode = Node(value)
        if (length == 0) {
            top = newNode
            bottom = newNode
        } else {
            val holdingPointer = top
            top = newNode
            newNode.next = holdingPointer
        }
        length++
    }

    fun pop(): Node? {
        if (top == null) {
            return null
        }
        if (length == 1) {
            bottom = null
        }
        val holdingPointer = top
        top = top?.next
        length--
        return holdingPointer
    }

    fun printList() {
        val array = ArrayList<String>()
        var currentNode: Node? = top
        while (currentNode != null) {
            array.add(currentNode.value)
            currentNode = currentNode.next
        }
        println("top: $array")
        println("length: $length")
        println("bottom: ${bottom?.value}")
    }
}

class Node(var value: String) {
    var next: Node? = null
}