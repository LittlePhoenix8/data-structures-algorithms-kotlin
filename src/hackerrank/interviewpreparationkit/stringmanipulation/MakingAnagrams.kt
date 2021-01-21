package hackerrank.interviewpreparationkit.stringmanipulation

import java.lang.StringBuilder

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 * */
fun main() {
    val makingAnagrams = MakingAnagrams()
    println(makingAnagrams.answer("cde", "abc")) //4
    println(makingAnagrams.answer("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")) //30
}

class MakingAnagrams {
    fun answer(first: String?, second: String): Int {
        var count = 0
        val firstWord = StringBuilder(first)
        for (element in second) {
            var exists = false
            for (x in firstWord.indices) {
                if (element == firstWord[x]) {
                    exists = true
                    firstWord.deleteCharAt(x)
                    break
                }
            }
            if (!exists) {
                count++
            }
        }
        count += firstWord.length
        return count
    }
}