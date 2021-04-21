package lettcodeexercices.medium

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * */
fun main() {
    val zigZagConversion = ZigZagConversion()
    println(zigZagConversion.convert("PAYPALISHIRING", 3)) //"PAHNAPLSIIGYIR"
    println(zigZagConversion.convert("PAYPALISHIRING", 4)) //"PINALSIGYAHRPI"
    println(zigZagConversion.convert("AB", 1)) //"AB"
    println(zigZagConversion.convert("ABCD", 2)) //"ACBD"
    println(zigZagConversion.convert("PAYPALISHIRING", 5)) //""PHASIYIRPLIGAN""
}

class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows < 2) {
            return s
        }
        //create matrix
        val matrix = Array(numRows) { StringBuilder() }
        var y = 0
        //populate matrix
        var goDown = true
        for(c in s) {
            matrix[y].append(c)
            if (y < numRows - 1) {
                if (goDown) {
                    y++
                } else {
                    goDown = if (y == 0) {
                        y++
                        true
                    } else {
                        y--
                        false
                    }
                }
            } else {
                y--
                goDown = false
            }
        }
        val stringBuilder = StringBuilder()
        //read matrix and build string
        for (i in 0 until numRows) {
            stringBuilder.append(matrix[i].toString())
        }
        return stringBuilder.toString()
    }
    fun convert2(s: String, numRows: Int): String {
        if (numRows < 2) {
            return s
        }
        //create matrix
        val matrix = ArrayList<Array<Char>>()
        var x = 0
        var y = 0
        matrix.add(Array(numRows) { ' ' })
        //populate matrix
        val middleColumns = if (numRows > 2) numRows - 2 else 0
        var colums = 0
        for(c in s) {
            matrix[x][y] = c
            if(y < numRows - 1 && colums == 0) {
                y++
            } else if(y < numRows - 1 && colums != 0) {
                colums--
                x++
                y--
                matrix.add(Array(numRows) { ' ' })
            } else {
                x++
                y--
                colums = middleColumns
                matrix.add(Array(numRows) { ' ' })
            }
        }
        val stringBuilder = StringBuilder()
        //read matrix and build string
        for(j in 0 until numRows) {
            for(i in matrix.indices) {
                if (matrix[i][j] != ' ') {
                    stringBuilder.append(matrix[i][j])
                }
            }
        }
        return stringBuilder.toString()
    }
}