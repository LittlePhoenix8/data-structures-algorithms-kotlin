package lettcodeexercices

fun main() {
    val excelSheetColumnNumber = ExcelSheetColumnNumber()
    println(excelSheetColumnNumber.titleToNumber("A")) //1
    println(excelSheetColumnNumber.titleToNumber("AB")) //28
    println(excelSheetColumnNumber.titleToNumber("ZY")) //701
}

class ExcelSheetColumnNumber {
    fun titleToNumber(s: String): Int {
        if (s.isEmpty()) {
            return -1
        }
        var sum = 0
        for (c in s.toUpperCase().toCharArray()) {
            sum *= 26
            sum += c - 'A' + 1
        }
        return sum
    }
}