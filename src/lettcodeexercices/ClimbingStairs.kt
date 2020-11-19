package lettcodeexercices

fun main() {
    val climbStairs = ClimbingStairs()
    println(climbStairs.climbStairs(2))//2
    println(climbStairs.climbStairs(3))//3
    println(climbStairs.climbStairs(4))//5
}

class ClimbingStairs {
    private val cache = HashMap<Int, Int>()
    fun climbStairs(n: Int): Int {
        return if(cache.containsKey(n)) {
            cache[n]!!
        } else {
            if(n <= 2) {
                n
            } else {
                cache[n] = climbStairs(n - 1) + climbStairs(n - 2)
                cache[n]!!
            }
        }
    }
}