package lettcodeexercices

fun main() {
    val missingNumber = MissingNumber()
    println(missingNumber.missingNumber(intArrayOf(3,0,1))) //2
    println(missingNumber.missingNumber(intArrayOf(0,1))) //2
    println(missingNumber.missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1))) //8
    println(missingNumber.missingNumber(intArrayOf(0))) //1
}

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        if(nums.isEmpty()) {
            return 0
        }
        val n = nums.size
        for (i in 0..n) {
            if(!nums.contains(i)) {
                return i
            }
        }
        return 0
    }
}