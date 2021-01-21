package hackerrank.interviewpreparationkit.sorting

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 * */
fun main() {
    val markAndToys = MarkAndToys()
    println(markAndToys.maximumToys(arrayOf(1, 12, 5, 111, 200, 1000, 10), 50)) //4
    println(markAndToys.maximumToys(arrayOf(1, 2, 3, 4), 7)) //3
    println(markAndToys.maximumToys(arrayOf(3, 7, 2, 9, 4), 15)) //3
}

class MarkAndToys {
    fun maximumToys(prices: Array<Int>, k: Int): Int {
        mergeSort(prices, 0, prices.size)
        var priceToys = 0
        var numToys = 0
        for(price in prices) {
            if((priceToys + price) <= k) {
                numToys++
                priceToys += price
            }
        }
        return numToys
    }

    private fun mergeSort(input: Array<Int>, start: Int, end: Int) {
        if (end - start < 2) {
            return
        }
        val mid = (start + end) / 2
        //split left array
        mergeSort(input, start, mid)
        //split right array
        mergeSort(input, mid, end)
        //merge
        merge(input, start, mid, end)
    }

    private fun merge(input: Array<Int>, start: Int, mid: Int, end: Int) {
        if (input[mid - 1] <= input[mid]) {
            return
        }
        var i = start
        var j = mid
        var tempIndex = 0
        val temp = Array<Int>(end - start) { 0 }
        while (i < mid && j < end) {
            if (input[i] <= input[j]) {
                temp[tempIndex] = input[i]
                i+=1
            } else {
                temp[tempIndex] = input[j]
                j+= 1
            }
            tempIndex += 1
        }
        //copy sorted
        System.arraycopy(input, i, input, start + tempIndex, mid -i)
        //copy leftover
        System.arraycopy(temp, 0, input, start, tempIndex)
    }
}