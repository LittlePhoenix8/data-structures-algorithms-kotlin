package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/count-primes/
 * */
fun main() {
    val countPrimes = CountPrimes()
    println(countPrimes.countPrimes(10)) //4 = 2, 3, 5, 7
    println(countPrimes.countPrimes(0)) //0
    println(countPrimes.countPrimes(1)) //0
    println(countPrimes.countPrimes(4)) //2 = 2, 3
    println(countPrimes.countPrimes(499979)) //41537
}

class CountPrimes {
    fun countPrimes(n: Int): Int {
        if (n < 3) {
            return 0
        }
        val notPrime = BooleanArray(n)
        var count = 0
        for(i in 2 until n) {
            if (!notPrime[i]) {
                count++
                var j = 2
                while (i * j < n) {
                    notPrime[i * j] = true
                    j++
                }
            }
        }
        return count
    }
}