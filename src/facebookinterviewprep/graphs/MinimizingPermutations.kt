package facebookinterviewprep.graphs

import java.util.Arrays
import java.util.LinkedList
import java.util.HashSet

/**
 * Minimizing Permutations
 * In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as
 * (a_1, a_2, ..., a_N). You want to rearrange the elements of the permutation into increasing order, repeatedly making
 * the following operation:
 * Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
 * Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.
 * Signature
 * int minOperations(int[] arr)
 * Input
 * Array arr is a permutation of all integers from 1 to N, N is between 1 and 8
 * Output
 * An integer denoting the minimum number of operations required to arrange the permutation in increasing order
 * Example
 * If N = 3, and P = (3, 1, 2), we can do the following operations:
 * Select (1, 2) and reverse it: P = (3, 2, 1).
 * Select (3, 2, 1) and reverse it: P = (1, 2, 3).
 * output = 2
 * */
fun main() {
    val minimizingPermutations = MinimizingPermutations()
    println(minimizingPermutations.minOperations(arrayOf(1, 2, 5, 4, 3))) //1
    println(minimizingPermutations.minOperations(arrayOf(3, 1, 2))) //2
}

class MinimizingPermutations {
    fun minOperations(arr: Array<Int>): Int {
        if (arr.size <= 1 || isSorted(arr)) {
            return 0
        }
        val visited = HashSet<String>()
        val queue = LinkedList<Item>()
        queue.add(Item(arr, 0))
        while (!queue.isEmpty()) {
            val item = queue.poll()
            val s: String = item.a.contentToString()
            if (visited.contains(s)) {
                continue
            }
            visited.add(s)
            for (x in item.a.indices) {
                for (y in x + 1 until item.a.size) {
                    val n = reverseArray(Arrays.copyOf(item.a, item.a.size), x, y)
                    if (isSorted(n)) {
                        return item.c + 1
                    }
                    queue.add(Item(n, item.c + 1))
                }
            }
        }
        return -1
    }

    private fun isSorted(arr: Array<Int>): Boolean {
        for (i in arr.indices) {
            if (arr[i] != i + 1) {
                return false
            }
        }
        return true
    }

    private fun reverseArray(arr: Array<Int>, start: Int, end: Int): Array<Int> {
        val n = (end - start) / 2
        for (i in 0..n) {
            val temp = arr[start + i]
            arr[start + i] = arr[end - i]
            arr[end - i] = temp
        }
        return arr
    }

    class Item(var a: Array<Int>, var c: Int)
}