package interviewquestion

/*
* input collection of numbers
* find matching pair that is equal to a given sum
* [1, 2, 3, 9] sum = 8 -> NO
* [1, 2, 4, 4] sum = 8 -> YES
* pair of numbers that their sums are equal to sum value
* in the first array there isn't any
* assume the input is an order array of numbers, same number can be repeated, always be integers, can be negatives
*
* first approach take number by number and compare sum -> O(n^2)
*
* second take number, see what number you need to complete the sum and search it using binary search
* take every number, if you reach the end it means there is no number
* binary search in order list is O(n log n), so it's a better answer
*
* take first and last element, if sum is larger than value move the element on right, if its smaller move the element on left,
* until you find the number or the index cross (in that case there is no number)
* loop the array one time, so time complexity is linear -> O(n)
*
* what to return? if you found it, return the indices of the pair of numbers or the numbers??
*
* if numbers are not ordered
* store complement on a hashset
* */

fun main() {
    val array1 = arrayOf(1, 2, 3, 9)
    val array2 = arrayOf(1, 2, 4, 4)
    val sum = 8
    println(hasPairWithSumSet(array1, sum))
    println(hasPairWithSumSet(array2, sum))
}

fun hasPairWithSum(input: Array<Int>, sum: Int): Boolean {
    var i = 0
    var j = input.size - 1
    while (i < j) {
        val value = input[i] + input[j]
        //if sum is same found the numbers
        if (value == sum) {
            return true
        }
        //if sum larger move j
        if (value > sum) {
            j--
        }
        //if sum smaller move i
        if (value < sum) {
            i++
        }
    }
    //if cross there is no number
    return false
}

fun hasPairWithSumSet(input: Array<Int>, sum: Int): Boolean {
    val set = HashSet<Int>()
    for (value in input) {
        if (set.contains(value)) {
            return true
        }
        set.add(sum - value)
    }
    return false
}