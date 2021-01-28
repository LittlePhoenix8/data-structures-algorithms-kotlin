package hackerrank.interviewpreparationkit.stacksqueues

import java.util.Stack

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
 * */
fun main() {
    val myQueue = MyQueue<Int>()
    myQueue.enqueue(42)
    myQueue.enqueue(14)
    println("Peek: ${myQueue.peek()}") //42

    val dequeue = myQueue.dequeue()
    println("Dequeue: $dequeue") //42
    println("Peek: ${myQueue.peek()}") //14

    val dequeue2 = myQueue.dequeue()
    println("Dequeue: $dequeue2") //12
    println("Peek: ${myQueue.peek()}") //null

    val dequeue3 = myQueue.dequeue()
    println("Dequeue: $dequeue3") //null
}

class MyQueue<T> {
    var stackNewestOnTop = Stack<T>()
    var stackOldestOnTop = Stack<T>()

    fun enqueue(value: T) {
        stackNewestOnTop.push(value)
    }

    fun peek(): T? {
        prepOldStack()
        if (stackOldestOnTop.isEmpty()) {
            return null
        }
        return stackOldestOnTop.peek()
    }

    fun dequeue(): T? {
        prepOldStack()
        if (stackOldestOnTop.isEmpty()) {
            return null
        }
        return stackOldestOnTop.pop()
    }

    private fun prepOldStack() {
        if (stackOldestOnTop.isEmpty()) {
            while (stackNewestOnTop.isNotEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop())
            }
        }
    }
}