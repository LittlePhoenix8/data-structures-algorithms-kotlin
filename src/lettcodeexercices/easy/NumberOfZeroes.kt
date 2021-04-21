package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/move-zeroes/
 * */
fun main() {
    val numberOfZeroes = NumberOfZeroes()
    val array = intArrayOf(0,1,0,3,12)
    numberOfZeroes.moveZeroes(array)
    println(array.joinToString(""))
}

class NumberOfZeroes {
    fun moveZeroes(nums: IntArray) {
        if (nums.isNotEmpty()) {
            var restOfZeroes = 0
            for (i in nums.indices) {
                if (nums[i] == 0) {
                    restOfZeroes++
                } else if (restOfZeroes > 0) {
                    nums[i - restOfZeroes] = nums[i]
                    nums[i] = 0
                }
            }
        }
    }

    fun moveZeroes2(nums: IntArray) {
        var numberOfZeros = 0
        var index = 0
        for(i in nums.indices) {
            if(nums[i] == 0) {
                numberOfZeros++
            } else {
                nums[index] = nums[i]
                index++
            }
        }
        if(numberOfZeros > 0) {
            for(i in nums.size - 1 downTo nums.size - numberOfZeros) {
                nums[i] = 0
            }
        }
    }
}