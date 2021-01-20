package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * */
fun main() {
    val pascalTriangleII = PascalTriangleII()
    println(pascalTriangleII.getRow(3).joinToString(",")) //[1,3,3,1]
    println(pascalTriangleII.getRow(0).joinToString(","))//[1]
    println(pascalTriangleII.getRow(1).joinToString(",")) //[1,1]
}

class PascalTriangleII {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex < 0) {
            return listOf()
        }
        if (rowIndex == 0) {
            return listOf(1)
        }
        val row = ArrayList<Int>()
        for (i in 0 until rowIndex + 1) {
            row.add(0, 1)
            for (j in 1 until row.size - 1) {
                row[j] = row[j] + row[j + 1]
            }
        }
        return ArrayList(row)
    }
}