package hackerrank.interviewpreparationkit.hashmaps

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 * */
fun main() {
    val twoStrings = TwoStrings()
    println(twoStrings.twoStrings("hello","world")) //YES
    println(twoStrings.twoStrings("hi","world")) //NO
    println(twoStrings.twoStrings("wouldyoulikefries","abcabcabcabcabcabc")) //NO
    println(twoStrings.twoStrings("hackerrankcommunity","cdecdecdecde")) //YES
    println(twoStrings.twoStrings("jackandjill","wentupthehill")) //YES
    println(twoStrings.twoStrings("writetoyourparents","fghmqzldbc")) //NO
    println(twoStrings.twoStrings("aardvark","apple")) //YES
    println(twoStrings.twoStrings("beetroot","sandals")) //NO
}

class TwoStrings {
    fun twoStrings(s1: String, s2: String): String {
        val map = HashMap<Char, Int>()
        val first = s1.toCharArray()
        val second = s2.toCharArray()
        for(letter in first) {
            if(!map.containsKey(letter)) {
                map[letter] = 0
            }
        }
        for(letter in second) {
            if(map.containsKey(letter)) {
                return "YES"
            }
        }
        return "NO"
    }
}