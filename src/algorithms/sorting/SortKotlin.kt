package algorithms.sorting

import java.text.Collator
import java.util.*

fun main() {
    val basket = arrayOf(2, 65, 34, 2, 1, 7, 8)
    basket.sort()
    println(basket.joinToString(" "))

    val spanish = arrayOf("único", "árbol", "cosas", "fútbol")
    val collator = Collator.getInstance(Locale("es", "ES"))
    val sorted = spanish.sortedWith { o1, o2 -> collator.compare(o1, o2) }
    println(sorted.joinToString(" "))
}