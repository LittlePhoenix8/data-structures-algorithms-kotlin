package lettcodeexercices

fun main() {
    val majorityElement = MajorityElement()
    println(majorityElement.majorityElement(intArrayOf(3,2,3))) // 3
}

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val majoritySize = nums.size / 2
        var majority = 0
        val hashmap = HashMap<Int, Int>()
        for(num in nums) {
            if(hashmap.containsKey(num)) {
                //sum +1
                hashmap[num] = hashmap[num]!! + 1
            } else {
                //add value 1
                hashmap[num] = 1
            }
        }
        hashmap.forEach {
            if(it.value > majoritySize) {
                majority = it.key
            }
        }

        return majority
    }
}