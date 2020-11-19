package interviewquestion.facebook

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.joinToString
import kotlin.collections.sortWith
import kotlin.collections.toTypedArray

fun main() {
    val mergeIntervals = MergeIntervals()
    printList(mergeIntervals.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))) //[1,6],[8,10],[15,18]
    printList(mergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)))) //[1,5]
    printList(mergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 4)))) //[0,4]
    printList(mergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3)))) //[1,4]
    printList(mergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 5)))) //[0,5]
    printList(mergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(0, 2), intArrayOf(3, 5)))) //[0,5]
    printList(mergeIntervals.merge(arrayOf(intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf(6, 7), intArrayOf(8, 9), intArrayOf(1, 10)))) //[1,10]
}

private fun printList(array: Array<IntArray>) {
    val stringBuilder = StringBuilder()
    stringBuilder.append("[")
    for (pair in array) {
        stringBuilder.append("[${pair.joinToString(",")}], ")
    }
    stringBuilder.append("]")
    println(stringBuilder.toString())
}

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size < 2) {
            return intervals
        }
        intervals.sortWith { o1, o2 -> o1[0].compareTo(o2[0]) }
        Arrays.sort(intervals) { o1, o2 -> o1[0].compareTo(o2[0]) }
        val list = ArrayList<IntArray>()
        var compare = intervals[0]
        list.add(compare)
        for (interval in intervals) {
            if (interval[0] <= compare[1]) {
                compare[1] = kotlin.math.max(compare[1], interval[1])
            } else {
                compare = interval
                list.add(compare)
            }
        }
        return list.toTypedArray()
    }
}