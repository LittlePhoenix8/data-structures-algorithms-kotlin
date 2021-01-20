package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/min-stack/
 * */
fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())

    val minStack2 = MinStack()
    minStack2.push(2147483646)
    minStack2.push(2147483646)
    minStack2.push(2147483647)
    println(minStack2.top())
    minStack2.pop()
    println(minStack2.getMin())
    minStack2.pop()
    println(minStack2.getMin())
    minStack2.pop()
    minStack2.push(2147483647)
    println(minStack2.top())
    println(minStack2.getMin())
    minStack2.push(-2147483648)
    println(minStack2.top())
    println(minStack2.getMin())
    minStack2.pop()
    println(minStack2.getMin())
}

class MinStack {
    /** initialize your data structure here. */
    private val list = ArrayList<Int>()
    private var min: Int? = null

    fun push(x: Int) {
        if (min != null && x < min!!) {
            min = x
        }
        list.add(x)
    }

    fun pop() {
        val removed = list.removeAt(list.size - 1)
        if (removed == min) {
            min = null
        }
    }

    fun top(): Int {
        return list.first()
    }

    fun getMin(): Int {
        if(min == null) {
            for (i in list.indices) {
                if (min == null) {
                    min = list[i]
                } else if (list[i] < min!!) {
                    min = list[i]
                }
            }
        }
        return min!!
    }
}