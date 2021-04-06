package facebookinterviewprep.strings

/**
 * Matching Pairs
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after
 * swapping exactly two characters within s.
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth
 * index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which
 * s[i] and t[i] are equal.
 * Note: This means you must swap two characters at different indices.
 * Signature
 * int matchingPairs(String s, String t)
 * Input
 * s and t are strings of length N
 * N is between 2 and 1,000,000
 * Output
 * Return an integer denoting the maximum number of matching pairs
 * Example 1
 * s = "abcd"
 * t = "adcb"
 * output = 4
 * Explanation:
 * Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
 * Therefore, the number of matching pairs of s and t will be 4.
 * Example 2
 * s = "mno"
 * t = "mno"
 * output = 1
 * Explanation:
 * Two indices have to be swapped, regardless of which two it is, only one letter will remain the same.
 * If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
 * */
fun main() {
    val matchingPairs = MatchingPairs()
    println(matchingPairs.matchingPairs("abcde", "adcbe")) //5
    println(matchingPairs.matchingPairs("abcd", "abcd")) //2
}

class MatchingPairs {
    fun matchingPairs(s: String, t: String): Int {
        if(s == t) {
            return s.length - 2
        }
        val n = s.length
        if(n == 2) {
            return swap(0, 1, s.toCharArray(), t.toCharArray())
        }
        var i = -1
        var j = -1
        var pairs = 0
        for(k in s.indices) {
            if(s[k] == t[k]) {
                pairs++
            } else {
                if(i == -1){
                    i = k
                } else if(j == -1) {
                    j = k
                }
            }
        }
        if(j == -1) {
            if(i - 1 >= 0) {
                j = i - 1
            } else if(i + 1 < n) {
                j = i + 1
            }
            if(s[j] == t[j]) {
                pairs--
            }
        }
        pairs += swap(i, j, s.toCharArray(), t.toCharArray())
        return pairs
    }
    private fun swap(i: Int, j: Int, s: CharArray, t: CharArray): Int {
        //swap
        var pairs = 0
        val temp = s[i]
        s[i] = s[j]
        s[j] = temp
        //check if pair
        if(s[i] == t[i]) {
            pairs++
        }
        if(s[j] == t[j]) {
            pairs++
        }
        return pairs
    }
}