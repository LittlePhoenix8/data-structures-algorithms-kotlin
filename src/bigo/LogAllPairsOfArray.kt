package bigo

fun main() {
    val boxes: Array<Any> = arrayOf("a", "b", "c", "d", "e")
    logAllPairsOfArray(boxes)
}

fun logAllPairsOfArray(array: Array<Any>) {
    for (i in array.indices) { //O(n)
        for (j in array.indices) { //O(n)
            println("${array[i]}, ${array[j]}")
        }
    }
}

//O(n * n) -> O(n^2)