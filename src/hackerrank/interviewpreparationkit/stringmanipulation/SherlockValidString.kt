package hackerrank.interviewpreparationkit.stringmanipulation

import java.util.*

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * */
fun main() {
    val sherlockValidString = SherlockValidString()
    println(sherlockValidString.isValid("aabbcd")) //NO
    println(sherlockValidString.isValid("aabbccddeefghi")) //NO
    println(sherlockValidString.isValid("abcdefghhgfedecba")) //YES
}

class SherlockValidString {
    fun isValid(s: String): String {
        if (s.isEmpty()) {
            return "NO"
        }
        if (s.length <= 3) {
            return "YES"
        }
        val letters = IntArray(26)
        for (element in s) {
            letters[element - 'a']++
        }
        Arrays.sort(letters)
        var i = 0
        while (letters[i] == 0) {
            i++
        }
        val min = letters[i] //the smallest frequency of some letter
        val max = letters[25] // the largest frequency of some letter
        var result = "NO"
        if (min == max) {
            result = "YES"
        } else if (max - min == 1 && max > letters[24] || min == 1 && letters[i + 1] == max){
            result = "YES"
        }
        return result
    }
}