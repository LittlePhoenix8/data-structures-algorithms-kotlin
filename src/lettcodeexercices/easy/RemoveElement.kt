package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/remove-element/
 * */
fun main() {
    val removeElement = RemoveElement()
    println(removeElement.removeElement(intArrayOf(3,2,2,3), 3)) //2
    println(removeElement.removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2)) //5
    println(removeElement.removeElement2(intArrayOf(0,1,2,2,3,0,4,2), 2)) //5
}

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var length = nums.size
        var removed = 0
        for(i in nums.indices) {
            if(nums[i] == `val`) {
                nums[i] = -1
                length--
            }
        }
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] != -1) {
                //shift
                for (j in i - 1 downTo 0) {
                    if (nums[j] == -1) {
                        val temp = nums[j]
                        nums[j] = nums[i]
                        nums[i] = temp
                        removed++
                        break
                    }
                }
            } else {
                removed++
            }
            if (nums.size - removed == length) {
                break
            }
        }
        return length
    }

    fun removeElement2(nums: IntArray, `val`: Int): Int {
        var j = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[j++] = nums[i]
            }
        }
        return j
    }
}