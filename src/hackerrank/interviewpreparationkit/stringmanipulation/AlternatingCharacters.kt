package hackerrank.interviewpreparationkit.stringmanipulation

/**
 * https://www.hackerrank.com/challenges/alternating-characters/problem
 * */
fun main() {
    val alternatingCharacters = AlternatingCharacters()
    println(alternatingCharacters.alternatingCharacters("AAAA")) //3
    println(alternatingCharacters.alternatingCharacters("BBBBB")) //4
    println(alternatingCharacters.alternatingCharacters("ABABABAB")) //0
    println(alternatingCharacters.alternatingCharacters("BABABA")) //0
    println(alternatingCharacters.alternatingCharacters("AAABBB")) //4
    println(alternatingCharacters.alternatingCharacters("AAABBBAABB")) //6
    println(alternatingCharacters.alternatingCharacters("AABBAABB")) //4
    println(alternatingCharacters.alternatingCharacters("ABABABAA")) //1
    println(alternatingCharacters.alternatingCharacters("ABBABBAA")) //3
}

class AlternatingCharacters {
    fun alternatingCharacters(s: String): Int {
        var count = 0
        val letters = s.toCharArray()
        for(i in letters.indices) {
            if(i + 1 < letters.size && letters[i] == letters[i + 1]) {
                count++
            }
        }
        return count
    }
}