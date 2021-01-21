package hackerrank.interviewpreparationkit.stringmanipulation

/**
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem
 * */
fun main() {
    val specialStringAgain = SpecialStringAgain()
    println(specialStringAgain.substrCount(7, "abcbaba")) //10
    println(specialStringAgain.substrCount(4, "aaaa")) //10
    println(specialStringAgain.substrCount(5, "asasd")) //7
}

class SpecialStringAgain {
    fun substrCount(n: Int, s: String): Long {
        var answer: Long = n.toLong()
        var i = 0
        while(i < s.length) {
            //all same characters
            //repeat * (repeat + 1) /2 + length
            var repeat = 0
            while(i + 1 < s.length && s[i] == s[i + 1]) {
                repeat++
                i++
            }
            answer += (repeat * (repeat + 1)) / 2
            //different characters
            //pointer = 1
            //char[i + pointer] == char[i - 1]
            //char[i - pointer] == char[i - 1]
            //answer + length
            var pointer = 1
            while (i - pointer >= 0 && i + pointer < s.length && s[i + pointer] == s[i - 1] && s[i - pointer] == s[i - 1]) {
                answer++
                pointer++
            }
            i++
        }
        return answer
    }
}