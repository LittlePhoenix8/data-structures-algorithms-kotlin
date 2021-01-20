package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/valid-palindrome/
 * */
fun main() {
    val validPalindrome = ValidPalindrome()
    println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"))
}

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        if(s.isEmpty()) {
            return true
        }
        var i = 0
        var j = s.length - 1
        while(i < j) {
            if(!s[i].isLetterOrDigit()) {
                i++
            } else if(!s[j].isLetterOrDigit()) {
                j--
            } else {
                if(s[i].equals(s[j], ignoreCase = true)) {
                    i++
                    j--
                } else {
                    return false
                }
            }
        }
        return true
    }
}