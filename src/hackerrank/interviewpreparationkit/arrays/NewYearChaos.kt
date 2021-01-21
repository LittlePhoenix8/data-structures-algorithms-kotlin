package hackerrank.interviewpreparationkit.arrays

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 * */
fun main() {
    val newYearChaos = NewYearChaos()
    newYearChaos.minimumBribes(arrayOf(2, 1, 5, 3, 4)) //3
    newYearChaos.minimumBribes(arrayOf(2, 5, 1, 3, 4)) //Too chaotic
}

class NewYearChaos {
    fun minimumBribes(q: Array<Int>) {
        var initial = ArrayList<Int>()
        var bribe = 0
        for(index in q.indices) {
            initial.add(index+1)
        }
        for(index in q.indices) {
            if(initial[index] < q[index]) {
                if(q[index] > index + 3) {
                    //too expensive
                    println("Too chaotic")
                    return
                } else {
                    //swipe
                    val swipe = stepsToMove(q, initial, index)
                    initial = swipeNumber(swipe, index, initial)
                    bribe += swipe
                }
            }
        }
        println(bribe)
    }
    private fun swipeNumber(total: Int, index: Int, initial: ArrayList<Int>): ArrayList<Int> {
        for(i in 1..total) {
            val swipeFirst = initial[index]
            initial[index] = initial[index + i]
            initial[index + i] = swipeFirst
        }
        return initial
    }

    private fun stepsToMove(q: Array<Int>, initial: ArrayList<Int>, index: Int): Int {
        return if(index + 2 <= initial.size - 1 && q[index] == initial[index + 2]) {
            2
        } else {
            1
        }
    }
}