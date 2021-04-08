package facebookinterviewprep.sorting

/**
 * Counting Triangles
 * Given a list of N triangles with integer side lengths, determine how many different triangles there are. Two
 * triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy
 * exactly the same three points.
 * Signature
 * int countDistinctTriangles(ArrayList<Sides> arr)
 * or
 * int countDistinctTrianges(int[][] arr)
 * Input
 * In some languages, arr is an Nx3 array where arr[i] is a length-3 array that contains the side lengths of the ith
 * triangle. In other languages, arr is a list of structs/objects that each represent a single triangle with side
 * lengths a, b, and c.
 * It's guaranteed that all triplets of side lengths represent real triangles.
 * All side lengths are in the range [1, 1,000,000,000]
 * 1 <= N <= 1,000,000
 * Output
 * Return the number of distinct triangles in the list.
 * Example 1
 * arr = [[2, 2, 3], [3, 2, 2], [2, 5, 6]]
 * output = 2
 * The first two triangles are the same, so there are only 2 distinct triangles.
 * Example 2
 * arr = [[8, 4, 6], [100, 101, 102], [84, 93, 173]]
 * output = 3
 * All of these triangles are distinct.
 * Example 3
 * arr = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
 * output = 1
 * All of these triangles are the same.
 * */
fun main() {
    CountingTriangles().run()
}

class CountingTriangles {
    private fun countDistinctTriangles(arr: ArrayList<Sides>): Int {
        if(arr.isEmpty()) {
            return 0
        }
        if(arr.size == 1) {
            return 1
        }
        var count = 0
        val hashmap = HashSet<ArrayList<Int>>()
        //O(n)
        for(i in arr.indices) {
            val side = arr[i]
            val list = arrayListOf(side.a, side.b, side.c)
            //O(n log n)
            list.sort()
            if(!hashmap.contains(list)) {
                hashmap.add(list)
                count++
            }
        }
        return count
    }

    class Sides(var a: Int, var b: Int, var c: Int)

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
        val arr1 = ArrayList<Sides>()
        arr1.add(Sides(7, 6, 5))
        arr1.add(Sides(5, 7, 6))
        arr1.add(Sides(8, 2, 9))
        arr1.add(Sides(2, 3, 4))
        arr1.add(Sides(2, 4, 3))
        val expected1 = 3
        val output1 = countDistinctTriangles(arr1)
        check(expected1, output1)
        val arr2 = ArrayList<Sides>()
        arr2.add(Sides(3, 4, 5))
        arr2.add(Sides(8, 8, 9))
        arr2.add(Sides(7, 7, 7))
        val expected2 = 3
        val output2 = countDistinctTriangles(arr2)
        check(expected2, output2)
        val arr3 = arrayListOf(Sides(2, 2, 3), Sides(3, 2, 2), Sides(2, 5, 6))
        val expected3 = 2
        val output3 = countDistinctTriangles(arr3)
        check(expected3, output3)
        val arr4 = arrayListOf(Sides(8, 4, 6), Sides(100, 101, 102), Sides(84, 93, 173))
        val expected4 = 3
        val output4 = countDistinctTriangles(arr4)
        check(expected4, output4)
        val arr5 = arrayListOf(Sides(5, 8, 9), Sides(5, 9, 8), Sides(9, 5, 8),
                Sides(9, 8, 5), Sides(8, 9, 5), Sides(8, 5, 9))
        val expected5 = 1
        val output5 = countDistinctTriangles(arr5)
        check(expected5, output5)
    }
}