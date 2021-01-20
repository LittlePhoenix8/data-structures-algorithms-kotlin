package lettcodeexercices.easy

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * */
fun main() {
    val excelSheetColumnTitle = ExcelSheetColumnTitle()
    println(excelSheetColumnTitle.convertToTitle(1)) //"A"
    println(excelSheetColumnTitle.convertToTitle(28)) //"AB"
    println(excelSheetColumnTitle.convertToTitle(701)) //"ZY"
}

class ExcelSheetColumnTitle {
    fun convertToTitle(n: Int): String {
        val stringBuilder = StringBuilder()
        val aInt = 'A'.toInt()
        var count = n
        while (count != 0) {
            stringBuilder.append(((count - 1) % 26 + aInt).toChar())
            count = (count - 1) / 26
        }
        return stringBuilder.reverse().toString()
    }
}