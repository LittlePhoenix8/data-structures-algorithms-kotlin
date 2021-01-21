package hackerrank.interviewpreparationkit.warmup

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 * */
fun main() {
    val repeatedString = RepeatedString()
    println(repeatedString.repeatedString("aba", 10)) //7
    println(repeatedString.repeatedString("a", 1000000000000)) //1000000000000
}

class RepeatedString {
    fun repeatedString(s: String, n: Long): Long {
        val text = StringBuilder()
        val words = s.toCharArray()
        var indice:Long = 0
        val a: Long = 0
        if(s.length == 1 && s == "a") {
            return n
        }
        if (n == words.size.toLong()) {
            val count = words.count { data -> data == 'a' }
            return count.toLong()
        }
        if (n > words.size.toLong()) {
            val long = words.size.toLong()
            return if (n % long == 0.toLong()) {
                val count = words.count { data -> data == 'a' }
                (count * n / long)
            } else {
                val amount = n / long
                val rest = n % long
                val count = words.count { data -> data == 'a' }
                val count2 = words.copyOfRange(0, rest.toInt()).count { data -> data == 'a' }
                val sum = (count * amount) + count2
                sum
            }
        }
        if (n < words.size.toLong()) {
            val count = words.copyOfRange(0, n.toInt()).count { data -> data == 'a' }
            return count.toLong()
        }
        while (indice < n) {
            for (word in words.indices) {
                text.append(words[word])
                indice += 1
                if (indice == n) {
                    return a
                }
            }
        }
        return a
    }
}