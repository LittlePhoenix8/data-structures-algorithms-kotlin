package facebookinterviewprep.arrays

/**
 * Reverse to Make Equal
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any
 * subarrays from array B any number of times.
 * Signature
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if B can be made equal to A, return false otherwise.
 *
 * Example
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 * */
fun main() {
    val reverseToMakeEqual = ReverseToMakeEqual()
    println(reverseToMakeEqual.areTheyEqual(arrayOf(1, 2, 3, 4), arrayOf(1, 4, 3, 2))) //true
    println(reverseToMakeEqual.areTheyEqual(arrayOf(1, 2, 3, 4), arrayOf(1, 4, 3, 3))) //false
    println(reverseToMakeEqual.areTheyEqual(arrayOf(1, 2, 3, 4, 1), arrayOf(2, 3, 1, 1, 4))) //true
    println(reverseToMakeEqual.areTheyEqual(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 3))) //false
    println(reverseToMakeEqual.areTheyEqual(arrayOf(1, 2), arrayOf(1, 2, 3))) //false
    println(reverseToMakeEqual.areTheyEqual(arrayOf(1, 2), arrayOf(1, 2))) //true
}

class ReverseToMakeEqual {
    fun areTheyEqual(arrA: Array<Int>, arrB: Array<Int>): Boolean {
        if(arrA.size != arrB.size) {
            return false
        }
        val hashmapA = HashMap<Int, Int>()
        val hashmapB = HashMap<Int, Int>()
        for(i in arrA.indices) {
            //store A
            if(!hashmapA.containsKey(arrA[i])) {
                hashmapA[arrA[i]] = 1
            } else {
                hashmapA[arrA[i]] = hashmapA[arrA[i]]!! + 1
            }
            //store B
            if(!hashmapB.containsKey(arrB[i])) {
                hashmapB[arrB[i]] = 1
            } else {
                hashmapB[arrB[i]] = hashmapB[arrB[i]]!! + 1
            }
        }
        for(i in arrA.indices) {
            if(!hashmapB.containsKey(arrB[i])) {
                return false
            } else {
                if(hashmapB[arrB[i]]!! != hashmapA[arrB[i]]!!) {
                    return false
                }
            }
        }
        return true
    }
}