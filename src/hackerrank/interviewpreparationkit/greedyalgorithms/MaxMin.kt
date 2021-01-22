package hackerrank.interviewpreparationkit.greedyalgorithms

/**
 * https://www.hackerrank.com/challenges/angry-children/problem
 * */
fun main() {
    val maxMin = MaxMin()
    println(maxMin.maxMin(3, arrayOf(10, 100, 300, 200, 1000, 20, 30))) //20
    println(maxMin.maxMin(4, arrayOf(1, 2, 3, 4, 10, 20, 30, 40, 100, 200))) //3
    println(maxMin.maxMin(2, arrayOf(1, 2, 1, 2, 1))) //0
    println(maxMin.maxMin(5, arrayOf(4504, 1520, 5857, 4094, 4157, 3902, 822, 6643, 2422, 7288, 8245, 9948,
            2822, 1784, 7802, 3142, 9739, 5629, 5413, 7232))) //1335
    println(maxMin.maxMin(3, arrayOf(100, 200, 300, 350, 400, 401, 402))) //2
}

class MaxMin {
    fun maxMin(k: Int, arr: Array<Int>): Int {
        //k = number of elements
        //arr = array of integers
        var minUnfairness = -1
        arr.sort()
        for (i in 0 until arr.size + 1 - k) {
            val selected = arr.copyOfRange(i, i + k)
            val difference = selected.last() - selected.first()
            if (minUnfairness == -1 || difference < minUnfairness) {
                minUnfairness = difference
            }
        }
        return minUnfairness
    }
}