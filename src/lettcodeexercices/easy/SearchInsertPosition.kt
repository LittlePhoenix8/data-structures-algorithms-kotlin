package lettcodeexercices.easy

fun main() {
    val searchInsertPosition = SearchInsertPosition()
    println(searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 5)) //2
    println(searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 2)) //1
    println(searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 7)) //4
    println(searchInsertPosition.searchInsert(intArrayOf(1,3,5,6), 0)) //0
    println(searchInsertPosition.searchInsert(intArrayOf(1), 0)) //0
}

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var index = 0
        for(i in nums.indices) {
            if(nums[i] == target) {
                index = i
                break
            } else if(nums[i] > target) {
                //not found
                index = i
                break
            } else if(i == nums.size - 1){
                index = i + 1
                break
            }
        }
        return index
    }
}