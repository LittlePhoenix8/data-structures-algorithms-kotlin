package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * */
fun main() {
    val longestPalindromicSubstring = LongestPalindromicSubstring()
    println(longestPalindromicSubstring.longestPalindrome("babad")) //"bab" or "aba"
    println(longestPalindromicSubstring.longestPalindrome("cbbd")) //"bb"
    println(longestPalindromicSubstring.longestPalindrome("a")) //"a"
    println(longestPalindromicSubstring.longestPalindrome("ac")) //"a"
}
class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) {
            return s
        }
        var current = 0
        var start = -1
        val array = s.toCharArray()
        for (i in array.indices) {
            if (isPalindrome(array, i - current - 1, i)) {
                start = i - current - 1
                current += 2
            } else if (isPalindrome(array, i - current, i)) {
                start = i - current
                current++
            }
        }
        return String(array, start, current)
    }

    private fun isPalindrome(s: CharArray, b: Int, e: Int): Boolean {
        var start = b
        var end = e
        if (start < 0) {
            return false
        }
        while (start < end) {
            if (s[start++] != s[end--]) {
                return false
            }
        }
        return true
    }
}