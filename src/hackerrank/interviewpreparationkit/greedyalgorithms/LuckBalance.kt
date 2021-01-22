package hackerrank.interviewpreparationkit.greedyalgorithms

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem
 * */
fun main() {
    val luckBalance = LuckBalance()
    println(luckBalance.luckBalance(3, arrayOf(arrayOf(5, 1), arrayOf(2, 1), arrayOf(1, 1), arrayOf(8, 1),
            arrayOf(10, 0), arrayOf(5, 0)))) //29
}

class LuckBalance {
    fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
        //k = nº of important contest that can be lost
        //contest [a, b] a = luck, b = importance
        var canLost = k
        var luck = 0
        val important = ArrayList<Int>()
        for (contest in contests) {
            if (contest.last() == 0) {
                //lost unimportant contest
                luck += contest.first()
            } else {
                important.add(contest.first())
            }
        }
        if (important.isNotEmpty()) {
            important.sortDescending()
            for (i in important) {
                if (canLost > 0) {
                    luck += i
                    canLost--
                } else {
                    luck -= i
                }
            }
        }
        return luck
    }
}