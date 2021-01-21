package hackerrank.interviewpreparationkit.hashmaps

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * */
fun main() {
    val sherlockAnagrams = SherlockAnagrams()
    println(sherlockAnagrams.sherlockAndAnagrams("abba")) //4
    println(sherlockAnagrams.sherlockAndAnagrams("abcd")) //0
    println(sherlockAnagrams.sherlockAndAnagrams("ifailuhkqq")) //3
    println(sherlockAnagrams.sherlockAndAnagrams("kkkk")) //10
    println(sherlockAnagrams.sherlockAndAnagrams("cdcd")) //5
}

class SherlockAnagrams {
    fun sherlockAndAnagrams(s: String): Int {
        var count = 0
        for(i in s.indices) {
            for(x in s.indices) {
                count += checkRowPalidromo(s, i, x)
            }
        }
        return count
    }

    private fun checkRowPalidromo(word: String, index: Int, countRound: Int): Int {
        var count = 0
        for(i in (index + 1) until word.count()) {
            if(i + countRound < word.count() && isPalidromo(word.substring(index, index + 1 + countRound), word.substring(i, i + 1 + countRound))) {
                count++
            }
        }
        return count
    }

    private fun isPalidromo(word1: String, word2: String): Boolean {
        val mapElement = HashMap<String, Int>()
        for(i in word1.indices) {
            if(mapElement[word1[i].toString()] == null) {
                mapElement[word1[i].toString()] = 1
            } else {
                mapElement[word1[i].toString()] = mapElement[word1[i].toString()]!! + 1
            }
        }
        for(i in word2.indices) {
            if(mapElement[word2[i].toString()] == null) {
                return false
            } else {
                mapElement[word2[i].toString()] =  mapElement[word2[i].toString()]!! - 1
            }
        }
        for((_, value) in mapElement) {
            if(value != 0) {
                return false
            }
        }
        return true
    }
}