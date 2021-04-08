package facebookinterviewprep.sorting

/**
 * Balanced Split
 * Given an array of integers (which may include repeated integers), determine if there's a way to split the array into
 * two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A
 * are strictly smaller than all of the integers in B.
 * Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
 * Signature
 * bool balancedSplitExists(int[] arr)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if such a split is possible, and false otherwise.
 * Example 1
 * arr = [1, 5, 7, 1]
 * output = true
 * We can split the array into A = [1, 1, 5] and B = [7].
 * Example 2
 * arr = [12, 7, 6, 7, 6]
 * output = false
 * We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all
 * integers in A are smaller than all integers in B.
 * */
fun main() {
    BalancedSplit().run()
}
class BalancedSplit {
    private fun balancedSplitExists2(arr: Array<Int>): Boolean {
        if (arr.isEmpty()) {
            return false
        }
        arr.sort()
        val n = arr.size
        var totalSum = arr.sum()
        if (totalSum % 2 != 0) {
            return false
        }
        var remaining = 0
        for (i in n - 1 downTo 0) {
            totalSum -= arr[i]
            remaining += arr[i]
            if (totalSum == remaining && arr[i - 1] < arr[i]) {
                return true
            }
            if (totalSum < remaining) {
                break
            }
        }
        return false
    }

    private fun balancedSplitExists(arr: Array<Int>): Boolean {
        if (arr.isEmpty()) {
            return false
        }
        arr.sort()
        val total = arr.sum()
        val middle = total / 2
        val a = ArrayList<Int>()
        val b = ArrayList<Int>()
        var i = 0
        var sum = 0
        while(i < arr.size && sum < middle) {
            a.add(arr[i])
            sum += arr[i]
            i++
        }
        sum = 0
        while(i < arr.size && sum < middle) {
            b.add(arr[i])
            sum += arr[i]
            i++
        }
        if(a.isEmpty() || b.isEmpty()) {
            return false
        }
        return isBalanced(a, b)
    }

    private fun isBalanced(a: ArrayList<Int>, b: ArrayList<Int>): Boolean {
        if(a.sum() != b.sum()) {
            return false
        }
        for(i in b.indices) {
            for(j in a.indices) {
                if(a[j] >= b[i]) {
                    return false
                }
            }
        }
        return true
    }

    var testCaseNumber = 1
    fun check(expected: Boolean, output: Boolean) {
        val result = expected == output
        val rightTick = '\u2713'
        val wrongTick = '\u2717'
        if (result) {
            println("$rightTick Test #$testCaseNumber")
        } else {
            print("$wrongTick Test #$testCaseNumber: Expected ")
            print(expected)
            print(" Your output: ")
            print(output)
            println()
        }
        testCaseNumber++
    }

    fun run() {
        val arr1 = arrayOf(2, 1, 2, 5)
        val expected1 = true
        val output1 = balancedSplitExists(arr1)
        check(expected1, output1)
        val arr2 = arrayOf(3, 6, 3, 4, 4)
        val expected2 = false
        val output2 = balancedSplitExists(arr2)
        check(expected2, output2)
        println("sorting")
        val output3 = balancedSplitExists2(arr1)
        check(expected1, output3)
        val output4 = balancedSplitExists2(arr2)
        check(expected2, output4)
    }
}