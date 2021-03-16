package hackerrank.interviewpreparationkit.stacksqueues

import java.util.*

/**
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem
 * */
fun main() {
    val castleOnTheGrid = CastleOnTheGrid()
    println(castleOnTheGrid.minimumMoves(arrayOf("....", "...X", "X...", "...."), 0, 0, 3, 3)) //3
    println(castleOnTheGrid.minimumMoves(arrayOf(".X.", ".X.", "..."), 0, 0, 0, 2)) //3
    println(castleOnTheGrid.minimumMoves(arrayOf("...", ".X.", ".X."), 2, 0, 0, 2)) //2
    println(castleOnTheGrid.minimumMoves(arrayOf("...", ".X.", ".X."), 2, 0, 2, 2)) //3
    println(castleOnTheGrid.minimumMoves(arrayOf(".X..XX...X", "X.........", ".X.......X", "..........", "........X.", ".X...XXX..", ".....X..XX", ".....X.X..", "..........", ".....X..XX"), 9, 1, 9, 6)) //3
}

class CastleOnTheGrid {
    fun minimumMoves(grid: Array<String>, startX: Int, startY: Int, goalX: Int, goalY: Int): Int {
        val n = grid.size
        val m = grid.first().length
        val queue: Queue<Position> = LinkedList()
        val visited = Array(n) { Array(m) { -1 } }
        val predecessors = Array<Array<Position?>>(n) { Array(m) { null } }

        //-1 not visited
        //1 visited
        //0 partial visited
        queue.add(Position(startX, startY))
        while (queue.isNotEmpty()) {
            val position = queue.remove()
            visited[position.x][position.y] = 1
            var reachGoal = false
            //get adjacent nodes
            for (j in position.y downTo 0) {
                //if x,j != x && x,j not visited
                if (grid[position.x][j] == 'X') {
                    break
                } else if (visited[position.x][j] == -1) {
                    val newPos = Position(position.x, j)
                    queue.add(newPos)
                    visited[position.x][j] = 0
                    predecessors[position.x][j] = position
                    if (newPos.x == goalX && newPos.y == goalY) {
                        reachGoal = true
                    }
                }
            }
            for (j in position.y until m) {
                //if x,j != x && x,j not visited
                if (grid[position.x][j] == 'X') {
                    break
                } else if (visited[position.x][j] == -1) {
                    val newPos = Position(position.x, j)
                    queue.add(newPos)
                    visited[position.x][j] = 0
                    predecessors[position.x][j] = position
                    if (newPos.x == goalX && newPos.y == goalY) {
                        reachGoal = true
                    }
                }
            }
            for (i in position.x downTo 0) {
                if (grid[i][position.y] == 'X') {
                    break
                } else if (visited[i][position.y] == -1) {
                    val newPos = Position(i, position.y)
                    queue.add(newPos)
                    visited[i][position.y] = 0
                    predecessors[i][position.y] = position
                    if (newPos.x == goalX && newPos.y == goalY) {
                        reachGoal = true
                    }
                }
            }
            for (i in position.x until n) {
                if (grid[i][position.y] == 'X') {
                    break
                } else if (visited[i][position.y] == -1) {
                    val newPos = Position(i, position.y)
                    queue.add(newPos)
                    visited[i][position.y] = 0
                    predecessors[i][position.y] = position
                    if (newPos.x == goalX && newPos.y == goalY) {
                        reachGoal = true
                    }
                }
            }
            if (reachGoal) {
                break
            }
        }

        val stack = Stack<Position>()
        stack.add(Position(goalX, goalY))
        var prev = predecessors[goalX][goalY]
        while (prev != null) {
            stack.add(prev)
            val pos = stack.peek()
            prev = predecessors[pos.x][pos.y]
        }

        var steps = -1
        while (stack.isNotEmpty()) {
            stack.pop()
            steps++
        }
        return steps
    }
    class Position(val x: Int, val y: Int)
}