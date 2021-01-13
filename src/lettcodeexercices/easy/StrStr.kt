package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/implement-strstr/
 * */
fun main() {
    val strStr = StrStr()
    println(strStr.strStr("hello", "ll")) //2
    println(strStr.strStr("aaaaa", "bba")) //-1
    println(strStr.strStr("", "")) //0
    println(strStr.strStr("", "a")) //-1
    println(strStr.strStr("mississippi", "mississippi")) //-1
}

class StrStr {
    fun strStr(haystack: String, needle: String): Int {
        if(needle.isEmpty()) {
            return 0
        }
        if (haystack.isEmpty()) {
            return -1
        }
        for (i in haystack.indices) {
            if (i + needle.length > haystack.length) {
                break
            }
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    break
                }
                if (j == needle.length - 1) {
                    return i
                }
            }
        }
        return -1
    }
}