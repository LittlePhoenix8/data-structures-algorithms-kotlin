package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/valid-sudoku/
 * */
fun main() {
    val validSudoku = ValidSudoku()
    val sudoku1 = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'))
    println(validSudoku.isValidSudoku(sudoku1)) //true
    println(validSudoku.isValidSudoku2(sudoku1)) //true

    val sudoku2 = arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'))
    println(validSudoku.isValidSudoku(sudoku2)) //false
    println(validSudoku.isValidSudoku2(sudoku2)) //false

    val sudoku3 = arrayOf(
            charArrayOf('.','.','4','.','.','.','6','3','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'),
            charArrayOf('5','.','.','.','.','.','.','9','.'),
            charArrayOf('.','.','.','5','6','.','.','.','.'),
            charArrayOf('4','.','3','.','.','.','.','.','1'),
            charArrayOf('.','.','.','7','.','.','.','.','.'),
            charArrayOf('.','.','.','5','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'))
    println(validSudoku.isValidSudoku(sudoku3)) //false
    println(validSudoku.isValidSudoku2(sudoku3)) //false
}

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (board.isEmpty() || board.size != 9 || board.first().size != 9) {
            return false
        }
        for (i in board.indices) {
            val row = HashSet<Char>()
            val column = HashSet<Char>()
            val block = HashSet<Char>()
            for (j in board.indices) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false
                }
                if (board[j][i] != '.' && !column.add(board[j][i])) {
                    return false
                }
                val rowIndex = 3 * (i / 3)
                val colIndex = 3 * (i % 3)
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !block.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false
                }
            }
        }
        return true
    }

    fun isValidSudoku2(board: Array<CharArray>): Boolean {
        if (board.isEmpty() || board.size != 9 || board.first().size != 9) {
            return false
        }
        for (i in board.indices step 3) {
            for (j in board.indices step 3) {
                if (!checkSquare(i, j, board)) {
                    return false
                }
                if (!checkLine(board[i]) || !checkLine(board[i + 1]) || !checkLine(board[i + 2])) {
                    return false
                }
                if (!checkColumn(i, board) || !checkColumn(i + 1, board) || !checkColumn(i + 2, board)) {
                    return false
                }
            }
        }
        return true
    }

    private fun checkSquare(i: Int, j: Int, board: Array<CharArray>): Boolean {
        val set = HashSet<Char>()
        for (x in i until i + 3) {
            for (y in j until j + 3) {
                val num: Char = board[x][y]
                if (isValidSudokuChar(num)) {
                    if (!set.contains(num)) {
                        set.add(num)
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }

    private fun checkLine(line: CharArray): Boolean {
        val set = HashSet<Char>()
        for (num in line) {
            if (isValidSudokuChar(num)) {
                if (!set.contains(num)) {
                    set.add(num)
                } else {
                    return false
                }
            }
        }
        return true
    }

    private fun checkColumn(j: Int, column: Array<CharArray>): Boolean {
        val set = HashSet<Char>()
        for (x in 0 until column.first().size) {
            val num = column[x][j]
            if (isValidSudokuChar(num)) {
                if (!set.contains(num)) {
                    set.add(num)
                } else {
                    return false
                }
            }
        }
        return true
    }

    private fun isValidSudokuChar(number: Char): Boolean {
        return number.isDigit() && number in '1'..'9'
    }
}