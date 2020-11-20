package interviewquestion.google

import java.lang.StringBuilder

fun main() {
    println(removeCharFromString("aaaaa", 'a')) //""
    println(removeCharFromString("abc", 'b')) //"ac"
    println(removeCharFromStringRecursive("abc", 'b')) //"ac"
}

/**
 * https://javarevisited.blogspot.com/2015/04/how-to-remove-given-character-from.html#axzz6eMVFv9Ip
 * Write a program to remove a given character from String in Java.
 * Your program must remove all occurrences of a given character.
 * For example, if given String is "aaaaa" and String to remove is "a" then the output should be an empty String.
 * Similarly, if input String is "abc" and character to remove is "b" then your program must return "ac" as output.
 * You are not allowed to use any JDK method or third party method which solves this method directly, but you can use
 * basic String manipulation method like indexOf(), toChar() or substring() from java.lang.String class.
 * */
fun removeCharFromString(s: String, c: Char): String {
    val newString = StringBuilder()
    for (char in s) {
        if (char != c) {
            newString.append(char.toString())
        }
    }
    return newString.toString()
}

fun removeCharFromStringRecursive(s: String, c: Char): String {
    val index = s.indexOf(c)
    if (index == -1) {
        return s
    }
    return removeCharFromStringRecursive(s.substring(0, index) + s.substring(index + 1, s.length), c)
}
//O(n) TC
//O(n) SC