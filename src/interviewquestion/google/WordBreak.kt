package interviewquestion.google

fun main() {
    val wordBreak = WordBreak()
    println(wordBreak.wordBreak("leetcode", listOf("leet", "code"))) //true
    println(wordBreak.wordBreak("applepenapple", listOf("apple", "pen"))) //true
    println(wordBreak.wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat"))) //false
    println(wordBreak.wordBreak("cars", listOf("car", "ca", "rs"))) //true
}

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val found = BooleanArray(s.length + 1)
        found[0] = true
        for (i in 1..s.length) {
            for (j in 0 until i) {
                val sub = s.substring(j, i)
                if (found[j] && wordDict.contains(sub)) {
                    found[i] = true
                    break
                }
            }
        }
        return found[s.length]
    }
}