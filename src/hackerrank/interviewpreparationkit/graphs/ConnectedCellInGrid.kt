package hackerrank.interviewpreparationkit.graphs

import java.util.*
import kotlin.math.max

/**
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 * */
fun main() {
    val connectedCellInGrid = ConnectedCellInGrid()
    println(connectedCellInGrid.maxRegion(arrayOf(arrayOf(1, 1, 0, 0), arrayOf(0, 1, 1, 0), arrayOf(0, 0, 1, 0), arrayOf(1, 0, 0, 0)))) //5
    println(connectedCellInGrid.maxRegion(arrayOf(arrayOf(1, 0, 1, 1, 0), arrayOf(1, 1, 0, 0, 1), arrayOf(0, 1, 1, 1, 0), arrayOf(0, 0, 0, 0, 1), arrayOf(1, 1, 1, 0, 0)))) //10
}

class ConnectedCellInGrid {
    fun maxRegion(grid: Array<Array<Int>>): Int {
        val n = grid.size
        val m = grid.first().size
        var maxCells = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 1) {
                    val cells = bfs(grid, n, m, i, j)
                    maxCells = max(maxCells, cells)
                }
            }
        }
        return maxCells
    }

    private fun bfs(grid: Array<Array<Int>>, rows: Int, cols: Int, i: Int, j: Int): Int {
        var cells = 0
        val queue: Queue<Array<Int>> = LinkedList()
        queue.add(arrayOf(i, j))
        while (!queue.isEmpty()) {
            val item = queue.remove()
            val x = item[0]
            val y = item[1]
            if (grid[x][y] == 1) {
                cells++
                grid[x][y] = -1
                //check the rest of the matrix
                pushIfValid(queue, rows, cols, x - 1, y) //left
                pushIfValid(queue, rows, cols, x + 1, y) //right
                pushIfValid(queue, rows, cols, x, y - 1) //up
                pushIfValid(queue, rows, cols, x, y + 1) //down

                pushIfValid(queue, rows, cols, x - 1, y - 1) //up left
                pushIfValid(queue, rows, cols, x + 1, y - 1) //up right

                pushIfValid(queue, rows, cols, x - 1, y + 1) //down left
                pushIfValid(queue, rows, cols, x + 1, y + 1) //down right
            }
        }
        return cells
    }

    private fun pushIfValid(queue: Queue<Array<Int>>, rows: Int, cols: Int, x: Int, y: Int) {
        if ((x in 0 until rows) && (y in 0  until cols)) {
            queue.add(arrayOf(x, y))
        }
    }
}