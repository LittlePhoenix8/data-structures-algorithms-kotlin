package hackerrank.interviewpreparationkit.hashmaps

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem
 * */
fun main() {
    val countTriplets = CountTriplets()
    println(countTriplets.countTriplets(arrayOf(1, 2, 2, 4), 2)) //2
    println(countTriplets.countTriplets(arrayOf(1, 3, 9, 9, 27, 81,), 3)) //6
    println(countTriplets.countTriplets(arrayOf(1, 5, 5, 25, 125), 5)) //4
}

class CountTriplets {
    fun countTriplets(arr: Array<Long>, ratio: Long): Long {
        var totalCount: Long = 0
        val posibilities = HashMap<Long, Long>()
        val combos = HashMap<Long, Long>()
        for(number in arr) {
            totalCount += if(combos.containsKey(number)) {
                combos[number]!!
            } else {
                0
            }
            val nextNumber = number * ratio
            combos[nextNumber] = (if(combos.containsKey(nextNumber)) {
                combos[nextNumber]!!
            } else {
                0
            }) + (if(posibilities.containsKey(number)) {
                posibilities[number]!!
            } else {
                0
            })
            posibilities[nextNumber] = (if(posibilities.containsKey(nextNumber)) {
                posibilities[nextNumber]!!
            } else {
                0
            }) + 1
        }
        return totalCount
    }
}