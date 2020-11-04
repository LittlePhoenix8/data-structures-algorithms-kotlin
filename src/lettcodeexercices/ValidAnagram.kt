package lettcodeexercices

fun main() {
    val validAnagram = ValidAnagram()
    println(validAnagram.isAnagram("anagram", "nagaram")) //true
}

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.isEmpty() || t.isEmpty()) {
            return false
        }
        if(s.length != t.length) {
            return false
        }
        if(s.length == 1 && t.length == 1) {
            return s == t
        }

        val values = HashSet<Char>()
        val hashMapS = HashMap<Char, Int>()
        val hashMapT = HashMap<Char, Int>()
        for (letter in s) {
            if (hashMapS.containsKey(letter)) {
                hashMapS[letter] = hashMapS[letter]!! + 1
            } else {
                hashMapS[letter] = 1
                values.add(letter)
            }
        }

        for (letter in t) {
            if (hashMapT.containsKey(letter)) {
                hashMapT[letter] = hashMapT[letter]!! + 1
            } else {
                hashMapT[letter] = 1
                values.add(letter)
            }
        }

        for (value in values) {
            if (hashMapS.containsKey(value) && hashMapT.containsKey(value)) {
                if(hashMapS[value] != hashMapT[value]) {
                    return false
                }
            } else {
                return false
            }
        }
        return true
    }
}