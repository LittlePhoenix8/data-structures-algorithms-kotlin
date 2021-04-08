package facebookinterviewprep.search

import kotlin.math.pow

/**
 * 1 Billion Users
 * We have N different apps with different user growth rates. At a given time t, measured in days, the number of users
 * using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app. These
 * apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many
 * total users there are when you add together the number of users from each app.
 * After how many full days will we have 1 billion total users across the N apps?
 * Signature
 * int getBillionUsersDay(float[] growthRates)
 * Input
 * 1.0 < growthRate < 2.0 for all growth rates
 * 1 <= N <= 1,000
 * Output
 * Return the number of full days it will take before we have a total of 1 billion users across all N apps.
 * Example 1
 * growthRates = [1.5]
 * output = 52
 * Example 2
 * growthRates = [1.1, 1.2, 1.3]
 * output = 79
 * Example 3
 * growthRates = [1.01, 1.02]
 * output = 1047
 * */
fun main() {
    OneBillionUsers().run()
}

class OneBillionUsers {
    private fun getBillionUsersDay(growthRates: Array<Float>): Int {
        var start = 0
        //var end = Int.MAX_VALUE //too big
        var end = 2000
        //Binary search O(log n)
        while (start < end) {
            val middle = start + (end - start) / 2
            if (hasBillionUserOnDays(middle, growthRates)) {
                end = middle
            } else {
                start = middle + 1
            }
        }
        return start
        //O(log n * m)
    }

    private fun hasBillionUserOnDays(middle: Int, growthRates: Array<Float>): Boolean {
        var users = 0f
        //O(m)
        for (i in growthRates.indices) {
            users += growthRates[i].pow(middle)
        }
        return users >= 1000000000
    }

    var testCaseNumber = 1
    fun check(expected: Int, output: Int) {
        val result = expected == output
        val rightTick = '\u2713'
        val wrongTick = '\u2717'
        if (result) {
            println("$rightTick Test #$testCaseNumber")
        } else {
            print("$wrongTick Test #$testCaseNumber: Expected ")
            printInteger(expected)
            print(" Your output: ")
            printInteger(output)
            println()
        }
        testCaseNumber++
    }

    private fun printInteger(n: Int) {
        print("[$n]")
    }

    fun run() {
        val test1 = arrayOf(1.1f, 1.2f, 1.3f)
        val expected1 = 79
        val output1 = getBillionUsersDay(test1)
        check(expected1, output1)
        val test2 = arrayOf(1.01f, 1.02f)
        val expected2 = 1047
        val output2 = getBillionUsersDay(test2)
        check(expected2, output2)
    }
}