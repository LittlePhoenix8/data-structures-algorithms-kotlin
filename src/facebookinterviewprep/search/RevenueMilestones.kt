package facebookinterviewprep.search

import kotlin.math.min

/**
 * Revenue Milestones
 * We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain
 * revenue milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach,
 * return an array containing the days on which Facebook reached every milestone.
 * Signature
 * int[] getMilestoneDays(int[] revenues, int[] milestones)
 * Input
 * revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N). milestones is
 * a length-K array of total revenue milestones.
 * Output
 * Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue. If the milestone is
 * never met, return -1.
 * Example
 * revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 * milestones = [100, 200, 500]
 * output = [4, 6, 10]
 * Explanation
 * On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively.
 * Day 6 is the first time that FB has >= $200 of total revenue.
 * */
fun main() {
    RevenueMilestones().run()
}

class RevenueMilestones {
    private fun getMilestoneDays(revenues: Array<Int>, milestones: Array<Int>): Array<Int> {
        val hashmap = HashMap<Int, Int>()
        //store hashmap with milestone position O(m)
        for(i in milestones.indices) {
            hashmap[milestones[i]] = i
        }
        //sort milestones O(m log m)
        milestones.sort()
        val result = Array(milestones.size) { 0 }
        var rev = 0
        var j = 0
        //sum revenues O(n)
        for(i in revenues.indices) {
            rev += revenues[i]
            //check if milestone is fulfilled O(m)
            while(j < milestones.size && rev >= milestones[j]) {
                val index = hashmap[milestones[j]]!!
                result[index] = i + 1
                j++
            }
        }
        return result
        //O(m) + O(m log m) + O(n*m)
    }

    var testCaseNumber = 1
    private fun check(expected: Array<Int>, output: Array<Int>) {
        val expectedSize = expected.size
        val outputSize = output.size
        var result = true
        if (expectedSize != outputSize) {
            result = false
        }
        for (i in 0 until min(expectedSize, outputSize)) {
            result = result and (output[i] == expected[i])
        }
        val rightTick = '\u2713'
        val wrongTick = '\u2717'
        if (result) {
            println("$rightTick Test #$testCaseNumber")
        } else {
            print("$wrongTick Test #$testCaseNumber: Expected ")
            printIntegerArray(expected)
            print(" Your output: ")
            printIntegerArray(output)
            println()
        }
        testCaseNumber++
    }

    private fun printIntegerArray(arr: Array<Int>) {
        val len = arr.size
        print("[")
        for (i in 0 until len) {
            if (i != 0) {
                print(", ")
            }
            print(arr[i])
        }
        print("]")
    }

    fun run() {
        val revenues1 = arrayOf(100, 200, 300, 400, 500)
        val milestones1 = arrayOf(300, 800, 1000, 1400)
        val expected1 = arrayOf(2, 4, 4, 5)
        val output1 = getMilestoneDays(revenues1, milestones1)
        check(expected1, output1)
        val revenues2 = arrayOf(700, 800, 600, 400, 600, 700)
        val milestones2 = arrayOf(3100, 2200, 800, 2100, 1000)
        val expected2 = arrayOf(5, 4, 2, 3, 2)
        val output2 = getMilestoneDays(revenues2, milestones2)
        check(expected2, output2)
    }
}