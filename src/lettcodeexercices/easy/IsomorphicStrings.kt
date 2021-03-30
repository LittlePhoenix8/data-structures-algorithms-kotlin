package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * */
fun main() {
    val isomorphicStrings = IsomorphicStrings()
    println(isomorphicStrings.isIsomorphic("egg", "add")) //true
    println(isomorphicStrings.isIsomorphic("foo", "bar")) //false
    println(isomorphicStrings.isIsomorphic("paper", "title")) //true
}

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length != t.length) {
            return false
        }
        val hashmap = HashMap<Char, Char>()
        for(i in s.indices) {
            val letter = s[i]
            val replace = t[i]
            if(!hashmap.containsKey(letter)) {
                if(hashmap.containsValue(replace)) {
                    return false
                }
                hashmap[letter] = replace
            } else if(hashmap[letter]!! != replace) {
                return false
            }
        }
        return true
    }
}