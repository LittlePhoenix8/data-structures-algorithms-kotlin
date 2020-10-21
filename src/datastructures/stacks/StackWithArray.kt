package datastructures.stacks

fun main() {
    val myStack = StackWithArray()
    myStack.push("google")
    myStack.push("Udemy")
    myStack.push("Discord")

    myStack.printList()

    println("Peek: ${myStack.peek()}")//discord
    println("Pop: ${myStack.pop()}")
    println("Peek: ${myStack.peek()}")//udemy
    println("Pop: ${myStack.pop()}")
    println("Peek: ${myStack.peek()}")//google
    println("Pop: ${myStack.pop()}")
    println("Peek: ${myStack.peek()}")//null

    myStack.printList()
}

class StackWithArray {
    var array = ArrayList<String>()

    fun peek(): String? {
        if (array.isNullOrEmpty()) {
            return null
        }
        return array.last()
    }

    fun push(value: String) {
        array.add(value)
    }

    fun pop(): String? {
        if (array.isNullOrEmpty()) {
            return null
        }
        return array.removeLast()
    }

    fun printList() {
        println("array: $array")
        println("length: ${array.size }")
    }
}
