package datastructures.trees

import java.lang.StringBuilder

fun main() {
    val priorityQueue = PriorityQueue()
    println("isEmpty: ${priorityQueue.isEmpty()}") //true
    println("front: ${priorityQueue.front()}") //null

    priorityQueue.enqueue("Sumit", 2)
    priorityQueue.enqueue("Gourav", 1)
    priorityQueue.enqueue("Piyush", 1)
    priorityQueue.enqueue("Sunny", 2)
    priorityQueue.enqueue("Sheru", 3)
    println("[${priorityQueue.printQueue()}]") //[Gourav Piyush Sumit Sunny Sheru]

    println("front: ${priorityQueue.front()?.value}") //Gourav
    println("rear: ${priorityQueue.rear()?.value}") //Sheru
    println("dequeue: ${priorityQueue.dequeue()?.value}") //Gourav
    println("[${priorityQueue.printQueue()}]") //[Piyush Sumit Sunny Sheru]

    priorityQueue.enqueue("Sunil", 2)
    println("[${priorityQueue.printQueue()}]") //[Piyush Sumit Sunny Sunil Sheru]
}

class PriorityQueue {
    private val items = ArrayList<PriorityNode>()

    fun enqueue(value: String, priority: Int) {
        val newNode = PriorityNode(value, priority)

        if (items.isEmpty()) {
            items.add(newNode)
        } else {
            var contain = false
            for (i in 0 until items.size) {
                if (items[i].priority > newNode.priority) {
                    items.add(i, newNode)
                    contain = true
                    break
                }
            }
            if (!contain) {
                items.add(newNode)
            }
        }
    }

    fun dequeue(): PriorityNode? {
        if (items.isEmpty()) {
            return null
        }
        return items.removeFirst()
    }

    fun front(): PriorityNode? {
        if (items.isEmpty()) {
            return null
        }
        return items.first()
    }

    fun rear(): PriorityNode? {
        if (items.isEmpty()) {
            return null
        }
        return items.last()
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    fun printQueue(): String {
        val value = StringBuilder()
        for (element in items) {
            value.append("${element.value} - ${element.priority}, ")
        }
        return value.toString()
    }
}

class PriorityNode(var value: String, var priority: Int)