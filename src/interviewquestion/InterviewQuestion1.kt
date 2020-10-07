package interviewquestion

/**
 * given 2 arrays, create a function that let's user know (true/false) whether these 2 arrays contain any common items
 * ex:
 * array1 = ["a", "b", "c", "x"]
 * array2 = ["z", "y", "i"]
 * should return false
 *
 * array1 = ["a", "b", "c", "x"]
 * array2 = ["z", "y", "x"]
 * should return true
 *
 * two parameters, arrays - no size limits
 * return true or false
 * O(n^2)
 */
fun main() {
    val array1 = arrayOf("a", "b", "c", "x")
    val array2 = arrayOf("z", "y", "i")
    val array3 = arrayOf("z", "y", "x")

    //println(containsCommonItems(array1, array2))
    //println(containsCommonItems(array1, array3))

    println(containsCommonItem2(array1, array2))
    println(containsCommonItem2(array1, array3))

    println(containsCommonItem3(array1, array2))
    println(containsCommonItem3(array1, array3))
}

//brute force solution
fun containsCommonItems(arr1: Array<String>, arr2: Array<String>): Boolean {
    for (i in arr1.indices) {
        for (j in arr2.indices) {
            if (arr1[i] == arr2[j]) {
                return true
            }
        }
    }
    return false
}
//O(a*b) Time Complexity
//O(1) Space Complexity

/**
 * array1 => object {
 * a: true,
 * b: true,
 * c: true,
 * x: true
 * }
 * array2[index] == object.properties
* */

fun containsCommonItem2(arr1: Array<String>, arr2: Array<String>): Boolean {
    //loop through first array and create object where properties == items in the array
    val map = HashMap<String, Boolean>()
    for (i in arr1.indices) {
        val item = arr1[i]
        if (!map.containsKey(item)) {
            map[item] = true
        }
    }
    //loop through second array and check if item in second array exists on create object
    for (j in arr2.indices) {
        if (map.containsKey(arr2[j])) {
            return true
        }
    }
    return false
}
//O(a+b) Time Complexity
//O(a) Space Complexity

fun containsCommonItem3(arr1: Array<String>, arr2: Array<String>): Boolean {
    return arr1.any { item -> arr2.contains(item) }
}
