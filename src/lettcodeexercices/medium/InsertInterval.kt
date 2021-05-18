package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/insert-interval/
 * */
fun main() {
    val insertInterval = InsertInterval()
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))) //[[1, 5], [6, 9]]
    val array = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
    printIntervals(insertInterval.insert(array, intArrayOf(4, 8))) //[[1, 2], [3, 10], [12, 16]]
    printIntervals(insertInterval.insert(arrayOf(), intArrayOf(5, 7))) //[[5, 7]]
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(2, 3))) //[[1, 5]]
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(2, 7))) //[[1, 7]]
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(6, 8))) //[[1, 5], [6, 8]]
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 5), intArrayOf(10, 12)), intArrayOf(6, 8))) //[[1, 5], [6, 8], [10, 12]]
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 3))) //[[0, 5]]
    printIntervals(insertInterval.insert(arrayOf(intArrayOf(1, 5)), intArrayOf(0, 6))) //[[0, 6]]
    //printIntervals(insertInterval.insert(arrayOf(intArrayOf()), intArrayOf())) //[]
}

private fun printIntervals(intervals: Array<IntArray>) {
    for (i in intervals) {
        print("[")
        print(i.joinToString(", "))
        print("]")
    }
    println()
}

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if(intervals.isEmpty()) {
            return arrayOf(newInterval)
        }
        var nInterval = newInterval
        val list = ArrayList<IntArray>()
        for(interval in intervals) {
            when {
                interval[1] < nInterval[0] -> list.add(interval)
                nInterval[1] < interval[0] -> {
                    list.add(nInterval)
                    nInterval = interval
                }
                else -> {
                    nInterval[0] = kotlin.math.min(interval[0], nInterval[0])
                    nInterval[1] = kotlin.math.max(interval[1], nInterval[1])
                }
            }
        }
        list.add(nInterval)
        return list.toTypedArray()
    }
}