package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/palindrome-number/
 * */
fun main() {
    val palindromeNumber = PalindromeNumber()
    println(palindromeNumber.isPalindrome(100)) //false
    println(palindromeNumber.isPalindrome(101)) //true
}

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        val palindrome = x.toString()
        val builder = StringBuilder()
        for(i in palindrome.length - 1 downTo 0) {
            builder.append(palindrome[i])
        }
        val newPalindrome = builder.toString()
        return palindrome == newPalindrome
    }
}