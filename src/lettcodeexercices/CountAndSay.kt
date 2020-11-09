package lettcodeexercices

fun main() {
    val countAndSay = CountAndSay()
    println(countAndSay.countAndSay(4))
}

class CountAndSay {
    fun countAndSay(n: Int): String {
        var curr = StringBuilder("1")
        var prev: StringBuilder
        var count: Int
        var say: Char
        for (i in 1 until n) {
            prev = curr
            curr = StringBuilder()
            count = 1
            say = prev[0]
            var j = 1
            val length = prev.length
            while (j < length) {
                if (prev[j] != say) {
                    curr.append(count).append(say)
                    count = 1
                    say = prev[j]
                } else {
                    count++
                }
                j++
            }
            curr.append(count).append(say)
        }
        return curr.toString()
    }
}