package interviewquestion.amazon

fun main() {
    val numberOfIslands = NumberOfIslands()
    val array1 = charArrayOf('1','1','1','1','0')
    val array2 = charArrayOf('1','1','0','1','0')
    val array3 = charArrayOf('1','1','0','0','0')
    val array4 = charArrayOf('0','0','0','0','0')
    println(numberOfIslands.numIslands(arrayOf(array1, array2, array3, array4))) //1

    val array5 = charArrayOf('1','1','0','0','0')
    val array6 = charArrayOf('1','1','0','0','0')
    val array7 = charArrayOf('0','0','1','0','0')
    val array8 = charArrayOf('0','0','0','1','1')
    println(numberOfIslands.numIslands(arrayOf(array5, array6, array7, array8))) //3
}

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        val y = grid.size
        if (y == 0) {
            return 0
        }
        val x = grid.first().size
        for (i in 0 until y) {
            for (j in 0 until x) {
                if (grid[i][j] == '1') {
                    depthFirstSearch(i, j, x, y, grid)
                    count++
                }
            }
        }
        return count
    }

    private fun depthFirstSearch(i: Int, j: Int, x: Int, y: Int, grid: Array<CharArray>) {
        if (i < 0 || i >= y || j < 0 || j >= x || grid[i][j] != '1') {
            return
        }
        grid[i][j] = '0'
        depthFirstSearch(i + 1, j, x, y, grid)
        depthFirstSearch(i - 1, j, x, y, grid)
        depthFirstSearch(i, j + 1, x, y, grid)
        depthFirstSearch(i, j - 1, x, y, grid)
    }
}