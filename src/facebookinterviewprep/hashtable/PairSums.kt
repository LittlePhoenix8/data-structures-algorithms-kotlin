package facebookinterviewprep.hashtable

/**
 * Pair Sums
 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are
 * considered different if one pair includes at least one array index which the other doesn't, even if they include the
 * same values.
 * Signature
 * int numberOfWays(int[] arr, int k)
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000,000,000].
 * k is in the range [1, 1,000,000,000].
 * Output
 * Return the number of different pairs of elements which sum to k.
 * Example 1
 * n = 5
 * k = 6
 * arr = [1, 2, 3, 4, 3]
 * output = 2
 * The valid pairs are 2+4 and 3+3.
 * Example 2
 * n = 5
 * k = 6
 * arr = [1, 5, 3, 3, 3]
 * output = 4
 * There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements,
 * and 4th and 5th elements).
 * */
fun main() {
    val pairSums = PairSums()
    println(pairSums.numberOfWays(arrayOf(1, 2, 3, 4), 5)) //2
    println(pairSums.numberOfWays(arrayOf(1, 2, 3, 4, 3), 6)) //2
    println(pairSums.numberOfWays(arrayOf(1, 5, 3, 3, 3), 6)) //4
    println(pairSums.numberOfWays(arrayOf(1, 2, 2, 3, 3, 4), 5)) //5
}

class PairSums {
    fun numberOfWays(arr: Array<Int>, k: Int): Int {
        var pairs = 0
        val hashmap = HashMap<Int, Int>()
        for(i in arr.indices) {
            if(!hashmap.containsKey(arr[i])) {
                hashmap[arr[i]] = 1
            } else {
                hashmap[arr[i]] = hashmap[arr[i]]!! + 1
            }
        }
        for(i in arr.indices) {
            val rest = k - arr[i]
            if(hashmap.containsKey(rest)) {
                //how many times
                if(hashmap[rest]!! == 1) {
                    pairs++
                    hashmap.remove(arr[i])
                } else {
                    pairs += hashmap[rest]!!
                    if(rest == arr[i]) {
                        hashmap.remove(arr[i])
                    }
                }
                hashmap.remove(rest)
            }
            if(hashmap.isEmpty()) {
                break
            }
        }
        return pairs
    }

    //TODO finish this
    fun numberOfWays2(arr: Array<Int>, k: Int): Int {
        var pairs = 0
        val hashmap = HashMap<Int, Int>()
        for(i in arr.indices) {
            if(!hashmap.containsKey(arr[i])) {
                hashmap[arr[i]] = 1
            } else {
                hashmap[arr[i]] = hashmap[arr[i]]!! + 1
            }
        }
        for (i in arr.indices) {
            val rest = k - arr[i]
            if (hashmap.containsKey(rest)) {
                if (rest == arr[i]) {
                    val w = hashmap[k / 2]!!
                    var multiple = w * (w - 1) / 2
                    if (w % 2 != 0) {
                        multiple = (multiple / w) * 2
                    }
                    pairs += multiple
                } else {
                    pairs += hashmap[rest]!! * hashmap[arr[i]]!!
                }
            }
        }
        return pairs / 2
    }
}