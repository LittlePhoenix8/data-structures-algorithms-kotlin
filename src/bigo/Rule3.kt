package bigo

fun compressBoxesTwice(boxes: Array<Any>) {
    boxes.forEach {
        println(it)
    }
    boxes.forEach {
        println(it)
    }
} //O(2n) -> O(n)

fun compressBoxesTwice(boxes: Array<Any>, boxes2: Array<Any>) {
    boxes.forEach {
        println(it)
    }
    boxes2.forEach {
        println(it)
    }
} //O(a + b)
