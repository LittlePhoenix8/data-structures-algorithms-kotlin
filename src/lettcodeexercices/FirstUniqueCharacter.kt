package lettcodeexercices

import kotlin.collections.HashMap

fun main() {
    val firstUniqueCharacter = FirstUniqueCharacter()
    println(firstUniqueCharacter.firstUniqChar("leetcode")) //0
    println(firstUniqueCharacter.firstUniqChar("loveleetcode")) //2
    println(firstUniqueCharacter.firstUniqChar("cc")) //-1
}

class FirstUniqueCharacter {
    fun firstUniqChar(s: String): Int {
        if (s.isEmpty()) {
            return -1
        }
        if (s.length == 1) {
            return 0
        }
        val charToC = HashMap<Char, Int>()
        for (ch in s.toCharArray()) {
            charToC[ch] = charToC.getOrDefault(ch, 0) + 1
        }
        for (i in s.indices) {
            if (charToC[s[i]] == 1) {
                return i
            }
        }
        return -1
    }
}