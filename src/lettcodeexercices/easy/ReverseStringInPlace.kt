package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/reverse-string/
 * */
fun main() {
    val reverseStringInPlace = ReverseStringInPlace()
    reverseStringInPlace.reverseString(charArrayOf('h','e','l','l','o'))
}

class ReverseStringInPlace {
    fun reverseString(s: CharArray) {
        println(s)
        var i = 0
        var j = s.size - 1
        while(i < j) {
            val temp = s[j]
            s[j] = s[i]
            s[i] = temp
            i++
            j--
        }
        println(s)
    }
}