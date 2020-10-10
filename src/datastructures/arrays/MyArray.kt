package datastructures.arrays

class MyArray {
    private var length: Int = 0
    private var capacity = 1
    private var data: Array<Any?> = Array(capacity) { null }

    fun get(index: Int): Any? {
        return if (index in 0 until length) {
            data[index]
        } else {
            "IndexOutOfBoundsException"
        }
    }

    fun push(item: Any): Int {
        if (capacity == length) {
            data = data.copyOf(capacity * 2)
            capacity *= 2
        }
        data[length] = item
        length++
        return length
    }

    fun pop(): Any? {
        val lastItem = data[length - 1]
        data[length - 1] = null
        length--
        return lastItem
    }

    fun delete(index: Int): Any? {
        return if (index in 0 until length) {
            val removeItem = data[index]
            shiftItems(index)
            removeItem
        } else {
            "IndexOutOfBoundsException"
        }
    }

    private fun shiftItems(index: Int) {
        for (i in index until length - 1) {
            data[i] = data[i + 1]
        }
        data[length - 1] = null
        length--
    }

    fun print() {
        print("MyArray { length: $length, data: { ")
        for (item in data) {
            print("$item ")
        }
        print("} }")
        println("")
    }
}

fun main() {
    val newArray = MyArray()
    newArray.push("hi")
    newArray.push("you")
    newArray.push("!")
    newArray.delete(2)
    newArray.push("are")
    newArray.push("nice")
    newArray.print()
    println(newArray.pop())
    newArray.print()
    println(newArray.get(10))
}