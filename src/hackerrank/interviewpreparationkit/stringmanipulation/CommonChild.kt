package hackerrank.interviewpreparationkit.stringmanipulation

/**
 * https://www.hackerrank.com/challenges/common-child/problem
 * */
fun main() {
    val commonChild = CommonChild()
    println(commonChild.commonChild("OUDFRMYMAW", "AWHYFCCMQX")) //2
    println(commonChild.commonChild("HARRY", "SALLY")) //2
    println(commonChild.commonChild("AA", "BB")) //0
}

class CommonChild {
    fun commonChild(s1: String, s2: String): Int {
        return getMax(s1.toCharArray(), s2.toCharArray(), s1.length, s2.length)
    }

    private fun getMax(x: CharArray, y: CharArray, m: Int, n: Int): Int {
        val saved = IntArray(n + 1)
        for(i in 1..m) {
            var prev = 0
            for(j in 1..n) {
                var temp = saved[j]
                if (x[i - 1] == y[j - 1]) {
                    saved[j] = prev + 1
                } else {
                    saved[j] = Math.max(saved[j], saved[j - 1])
                }
                prev = temp
            }
        }
        return saved[n]
    }
}