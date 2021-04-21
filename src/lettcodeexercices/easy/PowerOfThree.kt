package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/power-of-three/
 * */
fun main() {
    val powerOfThree = PowerOfThree()
    println(powerOfThree.isPowerOfThree(27))
    println(powerOfThree.isPowerOfThree(0))
    println(powerOfThree.isPowerOfThree(9))
    println(powerOfThree.isPowerOfThree(45))
    println(powerOfThree.isPowerOfThree(2))
}

class PowerOfThree {
    fun isPowerOfThree(n: Int): Boolean {
        if(n == 0) {
            return false
        }
        var num = n
        while(num % 3 == 0) {
            //is divisible by 3
            num /= 3
        }
        return num == 1
    }
}