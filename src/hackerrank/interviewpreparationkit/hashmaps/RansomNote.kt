package hackerrank.interviewpreparationkit.hashmaps

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 * */
fun main() {
    val ransomNote = RansomNote()
    ransomNote.checkMagazine(arrayOf("give", "me", "one", "grand", "today", "night"), arrayOf("give", "one", "grand", "today")) //Yes
    ransomNote.checkMagazine(arrayOf("two", "times", "three", "is", "not", "four"), arrayOf("two", "times", "two", "is", "four")) //No
    ransomNote.checkMagazine(arrayOf("ive", "got", "a", "lovely", "bunch", "of", "coconuts"), arrayOf("ive", "got", "some", "coconuts")) //No
}

class RansomNote {
    fun checkMagazine(magazine: Array<String>, note: Array<String>) {
        if (note.size > magazine.size) {
            println("No")
            return
        }
        val helper = HashMap<String, Int>()
        for(s in magazine) {
            if(!helper.containsKey(s)) {
                helper[s] = 1
            } else {
                helper[s] = helper[s]!! + 1
            }
        }
        for(s in note) {
            if(helper.containsKey(s)) {
                val count = helper[s]!! - 1
                helper[s] = count
                if (count < 0) {
                    println("No")
                    return
                }
            } else {
                println("No")
                return
            }
        }
        println("Yes")
    }
}