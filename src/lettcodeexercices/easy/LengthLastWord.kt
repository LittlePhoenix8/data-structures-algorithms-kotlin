package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/length-of-last-word/
 * */
fun main() {
    val lengthLastWord = LengthLastWord()
    println(lengthLastWord.lengthOfLastWord("Hello World")) //5
    println(lengthLastWord.lengthOfLastWord(" ")) //0
    println(lengthLastWord.lengthOfLastWord("")) //0
    println(lengthLastWord.lengthOfLastWord("a ")) //1
    println(lengthLastWord.lengthOfLastWord("b   a    ")) //1
}

class LengthLastWord {
    fun lengthOfLastWord(s: String): Int {
        if(s.isEmpty() || s == " ") {
            return 0
        }
        val words = s.split(" ").filter { a -> a.isNotEmpty() }
        if (words.isEmpty()) {
            return 0
        }
        if (words.size == 1) {
            return words.first().length
        }
        return words.last().length
    }
}