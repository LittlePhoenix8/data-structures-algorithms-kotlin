package bigo

import kotlin.math.floor

fun printFirstItemThenFirstHalfThenSayHi100Times(items: Array<Any>) {
    println(items[0])

    val middleIndex = floor((items.size / 2).toDouble())
    var index = 0

    while (index < middleIndex) {
        println(items[index])
        index++
    }

    for (i in 0 until 100) {
        println("hi")
    }
}

//O(n/2 + 100) -> O(n + 1)