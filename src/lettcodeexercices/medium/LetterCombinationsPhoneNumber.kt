package lettcodeexercices.medium

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * */
fun main() {
    val letterCombinationsPhoneNumber = LetterCombinationsPhoneNumber()
    println(letterCombinationsPhoneNumber.letterCombinations("23").joinToString(", ")) //[ad, ae, af, bd, be, bf, cd, ce, cf]
    println(letterCombinationsPhoneNumber.letterCombinations("").joinToString(", ")) // []
    println(letterCombinationsPhoneNumber.letterCombinations("2").joinToString(", ")) // [a, b, c]
    println(letterCombinationsPhoneNumber.letterCombinations("2738").joinToString(", ")) // []
}

class LetterCombinationsPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        val list = ArrayList<String>()
        if (digits.isEmpty()) {
            return list
        }
        letterCombination(0, StringBuilder(), list, digits, getPhoneMap())
        return list
    }

    private fun letterCombination(i: Int, stringBuilder: StringBuilder, list: ArrayList<String>, digits: String, map: HashMap<Char, String>) {
        if (i >= digits.length) {
            list.add(stringBuilder.toString())
            return
        }
        val d = digits[i]
        for (c in map[d]!!) {
            stringBuilder.append(c)
            letterCombination(i + 1, stringBuilder, list, digits, map)
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
        }
    }

    private fun getPhoneMap(): HashMap<Char, String> {
        val map = HashMap<Char, String>()
        map['2'] = "abc"
        map['3'] = "def"
        map['4'] = "ghi"
        map['5'] = "jkl"
        map['6'] = "mno"
        map['7'] = "pqrs"
        map['8'] = "tuv"
        map['9'] = "wxyz"
        return map
    }
}