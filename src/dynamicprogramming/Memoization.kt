package dynamicprogramming

val cache = HashMap<Int, Int>()

fun main() {
    println("addTo80: ${addTo80(5)}")
    println("addTo80: ${addTo80(5)}")

    println("memoizedAddTo80: ${memoizedAddTo80(5)}")
    println("memoizedAddTo80: ${memoizedAddTo80(5)}")
}

fun addTo80(n: Int): Int {
    println("long time")
    return n + 80
}

fun memoizedAddTo80(n: Int): Int {
    if (cache.containsKey(n)) {
        return cache[n]!!
    }
    println("long time")
    cache[n] = n + 80
    return cache[n]!!
}