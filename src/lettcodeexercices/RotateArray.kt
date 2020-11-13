package lettcodeexercices

fun main() {
    val rotateArray = RotateArray()
    val array1 = intArrayOf(1,2,3,4,5,6,7)
    rotateArray.rotate(array1, 3)
    println(array1.joinToString(",")) //[5,6,7,1,2,3,4]

    val array2 = intArrayOf(-1,-100,3,99)
    rotateArray.rotate(array2, 2)
    println(array2.joinToString(",")) //[3,99,-1,-100]
}

class RotateArray {
    fun rotate(nums: IntArray, k: Int) {
        if(nums.size > k) {
            val hashmap = HashMap<Int, Int>()
            var times = 1
            for(i in k - 1 downTo 0) {
                hashmap[i] = nums[nums.size - times]
                times++
            }
            for(i in nums.size - 1 - k downTo 0) {
                nums[i + k] = nums[i]
            }
            for(i in k - 1 downTo 0) {
                if(hashmap.containsKey(i)) {
                    nums[i] = hashmap[i]!!
                }
            }
        } else {
            var times = 0
            while(times < k) {
                var temp = nums[nums.size - 1]
                for(i in nums.size - 1 downTo 0) {
                    if(i > 0) {
                        nums[i] = nums[i -1]
                    } else {
                        nums[i] = temp
                    }
                }
                times++
            }
        }
    }
}