package datastructures.queues

import java.util.*

fun main() {
    val queue = MyQueue()
    queue.push(10)
    queue.push(4)
    queue.push(5)
    queue.pop()
    queue.pop()
}

class MyQueue {
    private val stack = Stack<Int>()
    private val helper = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
    }

    fun pop(): Int {
        while(stack.isNotEmpty()) {
            helper.push(stack.pop())
        }
        val pop: Int = helper.pop()
        while(helper.isNotEmpty()) {
            stack.push(helper.pop())
        }
        return pop
    }

    fun peek(): Int {
        while(stack.isNotEmpty()) {
            helper.push(stack.pop())
        }
        val peek: Int = helper.peek()
        while(helper.isNotEmpty()) {
            stack.push(helper.pop())
        }
        return peek
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }
}