package datastructures.linkedlist

fun main() {
    val myDoublyLinkedList = MyDoublyLinkedList(10)
    myDoublyLinkedList.append(5)
    myDoublyLinkedList.append(16)
    myDoublyLinkedList.prepend(1)
    myDoublyLinkedList.insert(2, 99)
    myDoublyLinkedList.remove(1)
    myDoublyLinkedList.printList()
}

class MyDoublyLinkedList(value: Int) {
    private var head: MyDoublyLinkedNode = MyDoublyLinkedNode(value)
    private var tail: MyDoublyLinkedNode? = head
    private var length = 1

    fun append(value: Int) {
        val newNode = MyDoublyLinkedNode(value)
        newNode.prev = tail
        tail?.next = newNode
        tail = newNode
        length++
    } //O(1)

    fun prepend(value: Int) {
        val newNode = MyDoublyLinkedNode(value)
        head.prev = newNode
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
                val newNode = MyDoublyLinkedNode(value)
                val leader = traverseToIndex(index - 1)
                val follower = leader?.next
                newNode.prev = leader
                newNode.next = follower

                leader?.next = newNode
                follower?.prev = newNode
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
                val newNext = leader?.next?.next
                leader?.next = newNext
                newNext?.prev = leader
                length--
            }
        }
    } //O(n)

    private fun traverseToIndex(index: Int): MyDoublyLinkedNode? {
        var count = 0
        var currentNode: MyDoublyLinkedNode? = head
        while (count != index) {
            currentNode = currentNode?.next
            count++
        }
        return currentNode
    }

    fun printList() {
        val array = ArrayList<Int>()
        var currentNode: MyDoublyLinkedNode? = head
        while (currentNode != null) {
            array.add(currentNode.value)
            currentNode = currentNode.next
        }
        println(array.toString())
        println("length: $length")
        println("tail: ${tail?.value}")
    }
}

class MyDoublyLinkedNode(var value: Int) {
    var prev: MyDoublyLinkedNode? = null
    var next: MyDoublyLinkedNode? = null
}