package facebookinterviewprep.strings

/**
 * Minimum Length Substrings
 * You are given two strings s and t. You can select any substring of string s and rearrange the characters of the
 * selected substring. Determine the minimum length of the substring of s such that string t is a substring of the
 * selected substring.
 * Signature
 * int minLengthSubstring(String s, String t)
 * Input
 * s and t are non-empty strings that contain less than 1,000,000 characters each
 * Output
 * Return the minimum length of the substring of s. If it is not possible, return -1
 * Example
 * s = "dcbefebce"
 * t = "fd"'
 * output = 5
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the
 * minimum length required is 5.
 * */
fun main() {
    val minLengthSubstring = MinimumLengthSubstrings()
    println(minLengthSubstring.minLengthSubstring("dcbefebce", "fd"))//5
    println(minLengthSubstring.minLengthSubstring("bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf", "cbccfafebccdccebdd"))//-1
}

class MinimumLengthSubstrings {
    fun minLengthSubstring(s: String, t: String): Int {
        if (s.isEmpty() || t.isEmpty()) {
            return -1
        }
        val hashmap = HashMap<Char, Int>()
        for(c in t) {
            if(hashmap.containsKey(c)) {
                hashmap[c] = hashmap[c]!! + 1
            } else {
                hashmap[c] = 1
            }
        }
        var minSize = 0
        for(c in s) {
            if(hashmap.containsKey(c)) {
                if(hashmap[c]!! > 1) {
                    hashmap[c] = hashmap[c]!! - 1
                } else {
                    hashmap.remove(c)
                }
            }
            if (hashmap.isEmpty()) {
                return minSize + 1
            } else {
                minSize++
            }
        }
        if(hashmap.isEmpty()) {
            return minSize
        }
        return -1
    }
}