package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/contains-duplicate/
 * */
fun main() {
    val containsDuplicate = ContainsDuplicate()
    println(containsDuplicate.containsDuplicate(intArrayOf(1,2,3,1))) //true
    println(containsDuplicate.containsDuplicate(intArrayOf(1,2,3,4))) //false
    println(containsDuplicate.containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2))) //true
}

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashmap = HashMap<Int,Boolean>()
        for(i in nums.indices) {
            if(!hashmap.containsKey(nums[i])) {
                hashmap[nums[i]] = true
            } else if(hashmap[nums[i]]!!) {
                return true
            }
        }
        return false
    }
}