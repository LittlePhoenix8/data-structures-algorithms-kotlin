package datastructures.arrays

fun main() {
    val str = "Hi My name is Andrei"
    println(str)
    println(reverse(str))
    println(reverse2(str))
    println(reverseWithString(str))
    println(reverseWithStringBuilder(str))
}

/**
 * Create a function that revwrses a string:
 * "Hi My name is Andrei" should be:
 * "ierdnA si eman yM iH"
 * */
fun reverse(str: String): String {
    if (str.length > 2) {
        val backwards = ArrayList<Char>()
        val totalItems = str.length - 1
        for (i in totalItems downTo 0) {
            backwards.add(str[i])
        }
        return backwards.joinToString("")
    }
    return str
}

fun reverse2(str: String): String {
    return str.toCharArray().reversed().joinToString("")
}

fun reverseWithString(str: String): String {
    if (str.length > 2) {
        var reversedWord = ""
        for (i in str.length - 1 downTo 0) {
            reversedWord += "${str[i]}"
        }
        return reversedWord
    }
    return str
}

fun reverseWithStringBuilder(str: String): String {
    if (str.length > 2) {
        val reversedWord = StringBuilder()
        for (i in str.length - 1 downTo 0) {
            reversedWord.append(str[i])
        }
        return reversedWord.toString()
    }
    return str
}