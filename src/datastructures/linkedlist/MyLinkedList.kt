package datastructures.linkedlist

fun main() {
    val myLinkedList = MyLinkedList(10)
    myLinkedList.append(5)
    myLinkedList.append(16)
    myLinkedList.prepend(1)
    myLinkedList.insert(2, 99)
    myLinkedList.insert(4, 88)
    myLinkedList.remove(4)
    myLinkedList.printList()
    myLinkedList.reverse().printList()
}
class MyLinkedList(value: Int) {
    private var head: MyLinkedNode = MyLinkedNode(value)
    private var tail: MyLinkedNode? = head
    private var length = 1

    fun append(value: Int) {
        val newNode = MyLinkedNode(value)
        tail?.next = newNode
        tail = newNode
        length++
    } //O(1)

    fun prepend(value: Int) {
        val newNode = MyLinkedNode(value)
        newNode.next = head
        head = newNode
        length++
    } //O(1)

    fun insert(index: Int, value: Int) {
        when {
            index < 0 || index >= length -> {
                println("Index Out of Bound")
            }
            index == 0 -> {
                prepend(value)
            }
            index == length - 1 -> {
                append(value)
            }
            else -> {
                val newNode = MyLinkedNode(value)
                val leader = traverseToIndex(index - 1)
                val holdingPointer = leader?.next
                leader?.next = newNode
                newNode.next = holdingPointer
                length++
            }
        }
    } //O(n)

    fun remove(index: Int) {
        when {
            index < 0 || index >= length -> {
                println("Index Out of Bound")
            }
            index == 0 -> {
                head = head.next!!
                length--
            }
            index == length - 1 -> {
                val last = traverseToIndex(index - 1)
                last?.next = null
                tail = last
                length--
            }
            else -> {
                val leader = traverseToIndex(index - 1)
                val unwantedNode = leader?.next
                leader?.next = unwantedNode?.next
                length--
            }
        }
    } //O(n)

    fun reverse(): MyLinkedList {
        if (head.next == null) {
            return this
        }
        var first = head
        tail = head
        var second = first.next
        while (second != null) {
            val temp = second.next
            second.next = first
            first = second
            second = temp
        }
        head.next = null
        head = first
        return this
    }

    private fun traverseToIndex(index: Int): MyLinkedNode? {
        var count = 0
        var currentNode: MyLinkedNode? = head
        while (count != index) {
            currentNode = currentNode?.next
            count++
        }
        return currentNode
    }

    fun printList() {
        val array = ArrayList<Int>()
        var currentNode: MyLinkedNode? = head
        while (currentNode != null) {
            array.add(currentNode.value)
            currentNode = currentNode.next
        }
        println(array.toString())
        println("length: $length")
        println("tail: ${tail?.value}")
    }
}

class MyLinkedNode(var value: Int) {
    var next: MyLinkedNode? = null
}