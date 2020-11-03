package lettcodeexercices

fun main() {
    val singleNumber = SingleNumber()
    println(singleNumber.singleNumber(intArrayOf(2,2,1))) //1
    println(singleNumber.singleNumber(intArrayOf(4,1,2,1,2))) //4
    println(singleNumber.singleNumber(intArrayOf(1))) //1
}

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums.first()
        }
        val hashmap = HashMap<Int, Int>()

        for(num in nums) {
            if(hashmap.containsKey(num)) {
                hashmap[num] = hashmap[num]!! + 1
            } else {
                hashmap[num] = 1
            }
        }

        for(num in nums) {
            if(hashmap.containsKey(num) && hashmap[num]!! == 1) {
                return num
            }
        }

        return 0
    }
}