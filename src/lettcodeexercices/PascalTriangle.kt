package lettcodeexercices

fun main() {
    val pascalTriangle = PascalTriangle()
    println(pascalTriangle.generate(5))
}

class PascalTriangle {
    //         1
    //       1   1
    //     1   2   1
    //   1   3   3   1
    // 1   4   6   4   1
    fun generate(numRows: Int): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        val row = ArrayList<Int>()
        for (i in 0 until numRows) {
            row.add(0, 1)
            for (j in 1 until row.size - 1) {
                row[j] = row[j] + row[j + 1]
            }
            list.add(ArrayList(row))
        }
        return list
    }
}