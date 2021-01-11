package interviewquestion.dailycodingproblem.december2020

/**
 * This problem was asked by Amazon.
 * Implement a stack that has the following methods:
 * push(val), which pushes an element onto the stack
 * pop(), which pops off and returns the topmost element of the stack.
 * If there are no elements in the stack, then it should throw an error or return null.
 * max(), which returns the maximum value in the stack currently.
 * If there are no elements in the stack, then it should throw an error or return null.
 * Each method should run in constant time.
 * */
fun main() {
    val stack = AmazonStack()
    stack.push(1)
    stack.push(10)
    stack.push(3)
    println(stack.max()) //10
    stack.push(11)
    println(stack.max()) //11
    println(stack.pop()) //11
    println(stack.max()) //10
    println(stack.pop()) //3
    println(stack.pop()) //10
    println(stack.max()) //1
}

class AmazonStack {
    val arrayList = ArrayList<StackIntWithMax>()

    fun push(value: Int) {
        if (arrayList.isEmpty()) {
            arrayList.add(StackIntWithMax(value, value))
        }
        val peek = peek()
        peek?.let {
            if (it.max > value) {
                arrayList.add(StackIntWithMax(value, it.max))
            } else {
                arrayList.add(StackIntWithMax(value, value))
            }
        }?: run {
            arrayList.add(StackIntWithMax(value, value))
        }
    }

    private fun peek(): StackIntWithMax? {
        if (arrayList.isEmpty()) {
            return null
        }
        return arrayList.last()
    }

    fun pop(): Int? {
        if (arrayList.isEmpty()) {
            return null
        }
        return arrayList.removeLast().value
    }

    fun max(): Int? {
        if (arrayList.isEmpty()) {
            return null
        }
        return peek()?.max
    }
}

class StackIntWithMax(var value: Int, var max: Int)