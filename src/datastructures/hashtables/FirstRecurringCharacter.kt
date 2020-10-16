package datastructures.hashtables

fun main() {
    println(firstRecurringCharacter(arrayOf(2, 35, 1, 2, 3, 5, 1, 2, 4))) //2
    println(firstRecurringCharacter(arrayOf(2, 1, 1, 2, 3, 5, 1, 2, 4))) //1
    println(firstRecurringCharacter(arrayOf(2, 3, 4, 5))) //null
    println(firstRecurringCharacter(arrayOf(1))) //null
    println(firstRecurringCharacter(arrayOf(1, 1))) //1
    println(firstRecurringCharacter(emptyArray())) //1
}

/**
 * Return first recurring character on the array
 *
 * Given an array = [2, 35, 1, 2, 3, 5, 1, 2, 4]
 * It should return 2
 *
 * Given an array = [2, 1, 1, 2, 3, 5, 1, 2, 4]
 * It should return 1
 *
 * Given an array = [2, 3, 4, 5]
 * It should return undefined
 * */

fun firstRecurringCharacter(array: Array<Int>): Int? {
    if (array.isEmpty()) {
        return null
    }
    if (array.size == 1) {
        return null
    }
    val hashmap = HashMap<Int, Int>()
    for (i in array.indices) {
        if (hashmap.containsKey(array[i])) {
            return array[i]
        } else {
            hashmap[array[i]] = array[i]
        }
        println(hashmap.toString())
    }
    return null
} //O(n)