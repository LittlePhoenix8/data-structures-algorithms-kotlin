package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/group-anagrams/
 * */
fun main() {
    val groupAnagrams = GroupAnagrams()
    println(groupAnagrams.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).joinToString(", "))
    println(groupAnagrams.groupAnagrams(arrayOf("")).joinToString(", "))
    println(groupAnagrams.groupAnagrams(arrayOf("a")).joinToString(", "))
}

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) {
            return listOf()
        }
        if (strs.size == 1) {
            return listOf(arrayListOf(strs[0]))
        }
        val hashmap = HashMap<HashMap<Char, Int>, ArrayList<String>>()
        for (word in strs) {
            val mapWord = HashMap<Char, Int>()
            for (c in word) {
                if (!mapWord.containsKey(c)) {
                    mapWord[c] = 1
                } else {
                    mapWord[c] = mapWord[c]!! + 1
                }
            }
            if (!hashmap.containsKey(mapWord)) {
                hashmap[mapWord] = ArrayList()
                hashmap[mapWord]!!.add(word)
            } else {
                hashmap[mapWord]!!.add(word)
            }
        }
        val result = ArrayList<ArrayList<String>>()
        for (words in hashmap.values) {
            result.addAll(listOf(words))
        }
        return result
    }
}