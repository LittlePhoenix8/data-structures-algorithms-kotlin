package lettcodeexercices.hard

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * */
fun main() {
    val regularExpressionMatching = RegularExpressionMatching()
    println(regularExpressionMatching.isMatch("aa", "a")) //false
    println(regularExpressionMatching.isMatch("aa", "a*")) //true
    println(regularExpressionMatching.isMatch("ab", ".*")) //true
    println(regularExpressionMatching.isMatch("aab", "c*a*b")) //true
    println(regularExpressionMatching.isMatch("mississippi", "mis*is*p*.")) //false

    println(regularExpressionMatching.isMatch("aaa", "a*a")) //true
    println(regularExpressionMatching.isMatch("ab", ".*c")) //false
    //println(regularExpressionMatching.isMatch("", ""))
}

class RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        if(s.isEmpty() && p.isEmpty()) {
            return true
        }
        if(s == p) {
            return true
        }
        var i = 0
        var j = 0
        while(i < s.length) {
            if(j >= p.length) {
                return false
            }
            //s[i] == p[j]
            //p[j] == '.'
            if(s[i] == p[j] || p[j] == '.') {
                i++
                j++
            } else {
                if(j + 1 < p.length && p[j + 1] == '*') {
                    //p[j + 1] == '*'
                    j += 2
                } else if(p[j] == '*') {
                    //p[j] == '*'
                    if(j - 1 >= 0 && (s[i] == p[j - 1] || p[j - 1] == '.')) {
                        //s[i] == p[j - 1]
                        i++
                    } else {
                        j++
                    }
                } else {
                    return false
                }
            }
        }
        if (j + 1 < p.length && s[i - 1] == p[j + 1]) {
            return true
        }
        if(j < p.length && p[j] != '*') {
            return false
        }
        if (j + 1 < p.length && p[j+ 1] != '*') {
            return false
        }
        return true
    }
}