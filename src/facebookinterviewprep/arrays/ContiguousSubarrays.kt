package facebookinterviewprep.arrays

import java.util.*

/**
 * Contiguous Subarrays
 * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous
 * subarrays that fulfill the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 * Signature
 * int[] countSubarrays(int[] arr)
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * Explanation:
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 * */
fun main() {
    val contiguousSubarrays = ContiguousSubarrays()
    println("Arrays")
    println(contiguousSubarrays.countSubarrays(arrayOf(3, 4, 1, 6, 2)).joinToString(", ")) //[1, 3, 1, 5, 1]
    println(contiguousSubarrays.countSubarrays(arrayOf(2, 4, 7, 1, 5, 3)).joinToString(", ")) //[1, 2, 6, 1, 3, 1]
    println("Stacks")
    println(contiguousSubarrays.countSubarrays2(arrayOf(3, 4, 1, 6, 2)).joinToString(", ")) //[1, 3, 1, 5, 1]
    println(contiguousSubarrays.countSubarrays2(arrayOf(2, 4, 7, 1, 5, 3)).joinToString(", ")) //[1, 2, 6, 1, 3, 1]
}

class ContiguousSubarrays {
    fun countSubarrays(arr: Array<Int>): Array<Int> {
        val n = arr.size
        if(n == 1) {
            return Array(n) { 1 }
        }
        val result = Array(n) { 0 }
        for(i in arr.indices) {
            if(i == 0) {
                result[i] = howManySubArrays(arr, i, i + 1, n - 1)
            } else if(i == n - 1) {
                result[i] = howManySubArrays(arr, i, n - 2, 0)
            } else {
                result[i] += howManySubArrays(arr, i, i + 1, n - 1)
                result[i] += howManySubArrays(arr, i, i - 1, 0)
            }
            result[i] += 1
        }
        return result
    }

    private fun howManySubArrays(arr: Array<Int>, index: Int, from: Int, to: Int): Int {
        var count = 0
        if(from < to) {
            for(i in from..to) {
                if(arr[index] > arr[i]) {
                    count++
                } else {
                    break
                }
            }
        } else {
            for(i in from downTo to) {
                if(arr[index] > arr[i]) {
                    count++
                } else {
                    break
                }
            }
        }
        return count
    }

    fun countSubarrays2(arr: Array<Int>): Array<Int> {
        val n = arr.size
        if(n == 1) {
            return Array(n) { 1 }
        }
        val stack = Stack<Int>()
        val left = Array(n) { 0 }
        left[0] = 1
        stack.push(0)
        for (i in 1 until n) {
            while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                left[i] = i + 1
            } else {
                left[i] = i - stack.peek()
            }
            stack.push(i)
        }
        val right = Array(n) { 0 }
        right[n - 1] = left[n - 1]
        stack.clear()
        stack.push(n - 1)
        for(i in n - 2 downTo 0) {
            while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop()
            }
            if (stack.isEmpty()) {
                right[i] = (n - i) + left[i] - 1
            } else {
                right[i] = (stack.peek() - i) + left[i] - 1
            }
            stack.push(i)
        }
        return right
    }
}