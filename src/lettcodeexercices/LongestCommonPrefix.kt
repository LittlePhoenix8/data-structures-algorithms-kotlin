package lettcodeexercices

fun main() {
    val longestCommonPrefix = LongestCommonPrefix()
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("flower","flow","flight"))) //"fl"
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("dog","racecar","car"))) //""
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("ab","a"))) //"a"
}

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs.first()
        }
        val stringBuilder = StringBuilder()
        val first = strs.first()
        var indexChar = 0
        while (indexChar < first.length) {
            var hasChar = false
            for (i in 1 until strs.size) {
                if (indexChar < strs[i].length && first[indexChar] == strs[i][indexChar]) {
                    hasChar = true
                } else {
                    hasChar = false
                    break
                }
            }
            if (hasChar) {
                stringBuilder.append(first[indexChar])
                indexChar++
            } else {
                break
            }
        }
        return stringBuilder.toString()
    }
}