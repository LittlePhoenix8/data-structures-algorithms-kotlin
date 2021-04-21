package facebookinterviewprep.heaps

import java.util.*
import kotlin.math.min

/**
 * Largest Triple Products
 * You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index
 * i (between 0 and n-1, inclusive), output[i] is equal to the product of the three largest elements out of arr[0..i]
 * (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
 * Note that the three largest elements used to form any product may have the same values as one another, but they must
 * be at different indices in arr.
 * Signature
 * int[] findMaxProduct(int[] arr)
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000].
 * Output
 * Return a list of n integers output[0..(n-1)], as described above.
 * Example 1
 * n = 5
 * arr = [1, 2, 3, 4, 5]
 * output = [-1, -1, 6, 24, 60]
 * The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.
 * Example 2
 * n = 5
 * arr = [2, 1, 2, 1, 2]
 * output = [-1, -1, 4, 4, 8]
 * The 3rd element of output is 2*2*1 = 4, the 4th is 2*2*1 = 4, and the 5th is 2*2*2 = 8.
 * */
fun main() {
    LargestTripleProducts().run()
}

class LargestTripleProducts {
    private fun findMaxProduct(arr: Array<Int>): Array<Int> {
        if (arr.size < 3) {
            return Array(arr.size) { -1 }
        }
        val result = Array(arr.size) { -1 }
        val maxheap = PriorityQueue<Int>(arr.size, Collections.reverseOrder())
        for (i in arr.indices) {
            if (i >= 2) {
                maxheap.addAll(arr.copyOfRange(0, i + 1))
                val value = maxheap.poll() * maxheap.poll() * maxheap.poll()
                result[i] = value
                maxheap.clear()
            }
            /*if (i < 2) {
                maxheap.add(arr[i])
            } else {
                if (maxheap.isNotEmpty()) {
                    maxheap.add(arr[i])
                } else {
                    maxheap.addAll(arr.copyOfRange(0, i + 1))
                }
                val value = maxheap.poll() * maxheap.poll() * maxheap.poll()
                result[i] = value
                maxheap.clear()
            }*/
        }
        return result
    }

    var testCaseNumber = 1
    fun check(expected: Array<Int>, output: Array<Int>) {
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
        val arr1 = arrayOf(1, 2, 3, 4, 5)
        val expected1 = arrayOf(-1, -1, 6, 24, 60)
        val output1 = findMaxProduct(arr1)
        check(expected1, output1)
        val arr2 = arrayOf(2, 4, 7, 1, 5, 3)
        val expected2 = arrayOf(-1, -1, 56, 56, 140, 140)
        val output2 = findMaxProduct(arr2)
        check(expected2, output2)
        val arr3 = arrayOf(2, 1, 2, 1, 2)
        val expected3 = arrayOf(-1, -1, 4, 4, 8)
        val output3 = findMaxProduct(arr3)
        check(expected3, output3)
    }
}