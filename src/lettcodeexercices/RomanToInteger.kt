package lettcodeexercices

fun main() {
    val romanToInteger = RomanToInteger()
    println(romanToInteger.romanToInt("III")) //3
    println(romanToInteger.romanToInt("IV")) //4
    println(romanToInteger.romanToInt("IX")) //9
    println(romanToInteger.romanToInt("LVIII")) //58
    println(romanToInteger.romanToInt("MCMXCIV")) //1994
    println(romanToInteger.romanToInt("DCXXI")) //621
}

class RomanToInteger {
    /**
     * I = 1
     * V = 5
     * X = 10
     * L = 50
     * C = 100
     * D = 500
     * M = 1000
     */
    fun romanToInt(s: String): Int {
        if (s.isEmpty()) {
            return -1
        }
        val array = s.toCharArray()
        var number = 0
        var i = 0
        while (i < array.size) {
            if (s[i] == 'I') {
                //IV = 4 IX = 9
                if (i + 1 < array.size && s[i + 1] == 'V') {
                    number += 4
                    i++
                } else if (i + 1 < array.size && s[i + 1] == 'X') {
                    number += 9
                    i++
                } else {
                    number += 1
                }
            }
            else if (s[i] == 'V') {
                number += 5
            }
            else if (s[i] == 'X') {
                //XL = 40 XC = 90
                if (i + 1 < array.size && s[i + 1] == 'L') {
                    number += 40
                    i++
                } else if (i + 1 < array.size && s[i + 1] == 'C') {
                    number += 90
                    i++
                } else {
                    number += 10
                }
            }
            else if (s[i] == 'L') {
                number += 50
            }
            else if (s[i] == 'C') {
                //CD = 400 CM = 900
                if (i + 1 < array.size && s[i + 1] == 'D') {
                    number += 400
                    i++
                } else if (i + 1 < array.size && s[i + 1] == 'M') {
                    number += 900
                    i++
                } else {
                    number += 100
                }
            }
            else if (s[i] == 'D') {
                number += 500
            }
            else if (s[i] == 'M') {
                number += 1000
            }
            i++
        }
        return number
    }
}