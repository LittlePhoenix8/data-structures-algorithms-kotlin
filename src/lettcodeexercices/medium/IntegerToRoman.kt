package lettcodeexercices.medium

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/integer-to-roman/
 * */
fun main() {
    val integerToRoman = IntegerToRoman()
    /*println("3 - ${integerToRoman.intToRoman(3)}, ${integerToRoman.intToRoman2(3)}, III")
    println("4 - ${integerToRoman.intToRoman(4)}, ${integerToRoman.intToRoman2(4)}, IV")
    println("7 - ${integerToRoman.intToRoman(7)}, ${integerToRoman.intToRoman2(7)}, VII")
    println("9 - ${integerToRoman.intToRoman(9)}, ${integerToRoman.intToRoman2(9)}, IX")
    println("10 - ${integerToRoman.intToRoman(10)}, ${integerToRoman.intToRoman2(10)}, X")
    println("12 - ${integerToRoman.intToRoman(12)}, ${integerToRoman.intToRoman2(12)}, XII")
    println("42 - ${integerToRoman.intToRoman(42)}, ${integerToRoman.intToRoman2(42)}, XLII")
    println("44 - ${integerToRoman.intToRoman(44)}, ${integerToRoman.intToRoman2(44)}, XLIV")
    println("49 - ${integerToRoman.intToRoman(49)}, ${integerToRoman.intToRoman2(49)}, XLIX")
    println("62 - ${integerToRoman.intToRoman(62)}, ${integerToRoman.intToRoman2(62)}, LXII")
    println("69 - ${integerToRoman.intToRoman(69)}, ${integerToRoman.intToRoman2(69)}, LXIX")
    println("100 - ${integerToRoman.intToRoman(100)}, ${integerToRoman.intToRoman2(100)}, C")
    println("102 - ${integerToRoman.intToRoman(102)}, ${integerToRoman.intToRoman2(102)}, CII")
    println("112 - ${integerToRoman.intToRoman(112)}, ${integerToRoman.intToRoman2(112)}, CXII")
    println("140 - ${integerToRoman.intToRoman(140)}, ${integerToRoman.intToRoman2(140)}, CXL")
    println("420 - ${integerToRoman.intToRoman(420)}, ${integerToRoman.intToRoman2(420)}, CDXX")
    println("670 - ${integerToRoman.intToRoman(670)}, ${integerToRoman.intToRoman2(670)}, DCLXX")
    println("900 - ${integerToRoman.intToRoman(900)}, ${integerToRoman.intToRoman2(900)}, CM")
    println("1000 - ${integerToRoman.intToRoman(1000)}, ${integerToRoman.intToRoman2(1000)}, M")
    println("2550 - ${integerToRoman.intToRoman(2550)}, ${integerToRoman.intToRoman2(2550)}, MMDL")
    println("3999 - ${integerToRoman.intToRoman(3999)}, ${integerToRoman.intToRoman2(3999)}, MMMCMXCIX")
    println("1994 - ${integerToRoman.intToRoman(1994)}, ${integerToRoman.intToRoman2(1994)}, MCMXCIV")*/
    println("3000 - ${integerToRoman.intToRoman(3000)}, ${integerToRoman.intToRoman2(3000)}, MMM")
}

class IntegerToRoman {
    fun intToRoman(num: Int): String {
        if(num < 1 || num > 3999) {
            return ""
        }
        return when {
            num < 10 -> singleNumToRoman(num)
            num in 10 until 100 -> doubleNumToRoman(num)
            num in 100 until 1000 -> tripleNumToRoman(num)
            else -> quadrupleNumToRoman(num)
        }
    }

    private fun singleNumToRoman(num: Int): String {
        when (num) {
            4 -> return "IV"
            9 -> return "IX"
            else -> {
                val stringBuilder = StringBuilder()
                var rest = num
                while (rest != 0) {
                    rest -= if (rest >= 5) {
                        stringBuilder.append("V")
                        5
                    } else {
                        stringBuilder.append("I")
                        1
                    }
                }
                return stringBuilder.toString()
            }
        }
    }

    private fun doubleNumToRoman(num: Int): String {
        val stringBuilder = StringBuilder()
        val secondDigit = num % 10
        var rest = num - secondDigit
        when (rest) {
            40 -> stringBuilder.append("XL")
            50 -> stringBuilder.append("L")
            90 -> stringBuilder.append("XC")
            else -> {
                while (rest != 0) {
                    rest -= if (rest >= 50) {
                        stringBuilder.append("L")
                        50
                    } else {
                        stringBuilder.append("X")
                        10
                    }
                }
            }
        }
        stringBuilder.append(singleNumToRoman(secondDigit))
        return stringBuilder.toString()
    }

    private fun tripleNumToRoman(num: Int): String {
        val stringBuilder = StringBuilder()
        val secondDigit = num % 10
        var rest = num - secondDigit
        while (rest != 0) {
            rest -= when {
                rest in 500 until 900 -> {
                    stringBuilder.append("D")
                    500
                }
                rest in 400 until 500 -> {
                    stringBuilder.append("CD")
                    400
                }
                rest in 900 until 1000 -> {
                    stringBuilder.append("CM")
                    900
                }
                rest < 100 -> {
                    stringBuilder.append(doubleNumToRoman(rest))
                    rest
                }
                else -> {
                    stringBuilder.append("C")
                    100
                }
            }
        }
        if (secondDigit > 0) {
            stringBuilder.append(doubleNumToRoman(secondDigit))
        }
        return stringBuilder.toString()
    }

    private fun quadrupleNumToRoman(num: Int): String {
        val stringBuilder = StringBuilder()
        val secondDigit = num % 10
        var rest = num - secondDigit
        while (rest != 0) {
            rest -= when {
                rest < 1000 -> {
                    stringBuilder.append(tripleNumToRoman(rest))
                    rest
                }
                else -> {
                    stringBuilder.append("M")
                    1000
                }
            }
        }
        if (secondDigit > 0) {
            stringBuilder.append(tripleNumToRoman(secondDigit))
        }
        return stringBuilder.toString()
    }

    fun intToRoman2(num: Int): String {
        if(num < 1 || num > 3999) {
            return ""
        }
        val hashmap = romansHashMap()
        val stringBuilder = StringBuilder()
        var base = 1000
        var n = num
        while (n > 0) {
            val digit = n / base
            if (digit != 0) {
                stringBuilder.append(hashmap[digit * base])
            }
            n %= base
            base /= 10
        }
        return stringBuilder.toString()
    }

    private fun romansHashMap(): HashMap<Int, String> {
        val hashmap = HashMap<Int, String>()
        hashmap[3000] = "MMM"
        hashmap[2000] = "MM"
        hashmap[1000] = "M"

        hashmap[900] = "CM"
        hashmap[800] = "DCCC"
        hashmap[700] = "DCC"
        hashmap[600] = "DC"
        hashmap[500] = "D"
        hashmap[400] = "CD"
        hashmap[300] = "CCC"
        hashmap[200] = "CC"
        hashmap[100] = "C"

        hashmap[90] = "XC"
        hashmap[80] = "LXXX"
        hashmap[70] = "LXX"
        hashmap[60] = "LX"
        hashmap[50] = "L"
        hashmap[40] = "XL"
        hashmap[30] = "XXX"
        hashmap[20] = "XX"
        hashmap[10] = "X"

        hashmap[9] = "IX"
        hashmap[8] = "VIII"
        hashmap[7] = "VII"
        hashmap[6] = "VI"
        hashmap[5] = "V"
        hashmap[4] = "IV"
        hashmap[3] = "III"
        hashmap[2] = "II"
        hashmap[1] = "I"
        return hashmap
    }
}