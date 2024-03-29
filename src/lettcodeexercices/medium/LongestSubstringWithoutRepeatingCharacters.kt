package lettcodeexercices.medium

import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * */
fun main() {
    val longest = LongestSubstringWithoutRepeatingCharacters()
    println(longest.lengthOfLongestSubstring("abcabcbb")) //3
    println(longest.lengthOfLongestSubstring("bbbbb")) //1
    println(longest.lengthOfLongestSubstring("pwwkew")) //3
    println(longest.lengthOfLongestSubstring("")) //0
    println(longest.lengthOfLongestSubstring(" ")) //1
    println(longest.lengthOfLongestSubstring("dvdf")) //3
}

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val hashmap = HashMap<Char, Int>()
        var count = 0
        var longest = 0
        for(i in s.indices) {
            if (!hashmap.containsKey(s[i])) {
                hashmap[s[i]] = 1
                count++
            }
            for (j in i + 1 until s.length) {
                if (hashmap.containsKey(s[j])) {
                    if (count >= longest) {
                        longest = count
                    }
                    count = 0
                    hashmap.clear()
                    break
                } else {
                    hashmap[s[j]] = 1
                    count++
                }
            }
        }
        return max(count, longest)
    }
}