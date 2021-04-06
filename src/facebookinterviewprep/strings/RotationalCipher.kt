package facebookinterviewprep.strings

import java.lang.StringBuilder

/**
 * Rotational Cipher
 *  One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
 *  Rotating a character means replacing it with another character that is a certain number of steps away in normal
 *  alphabetic or numerical order.
 *  For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
 *  Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
 *  and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
 *  Note that the non-alphanumeric characters remain unchanged.
 *  Given a string and a rotation factor, return an encrypted string.
 *  Signature
 *  string rotationalCipher(string input, int rotationFactor)
 *  Input
 *  1 <= |input| <= 1,000,000
 *  0 <= rotationFactor <= 1,000,000
 *  Output
 *  Return the result of rotating input a number of times equal to rotationFactor.
 *  Example 1
 *  input = Zebra-493?
 *  rotationFactor = 3
 *  output = Cheud-726?
 *  Example 2
 *  input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 *  rotationFactor = 39
 *  output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 * */
fun main() {
    val rotationalCipher = RotationalCipher()
    println(rotationalCipher.rotationalCipher("All-convoYs-9-be:Alert1.", 4)) //Epp-gsrzsCw-3-fi:Epivx5.
    println(rotationalCipher.rotationalCipher("abcdZXYzxy-999.@", 200)) //"stuvRPQrpq-999.@"
    println(rotationalCipher.rotationalCipher("hello.99", 0)) //"hello.99"
}

class RotationalCipher {
    fun rotationalCipher(input: String, rotationFactor: Int): String {
        if(rotationFactor == 0) {
            return input
        }
        val factorCharacter = if (rotationFactor > 25) {
            if (rotationFactor % 26 == 0) {
                26
            } else {
                rotationFactor % 26
            }
        } else {
            rotationFactor
        }
        val factorNumber = if (rotationFactor > 9) {
            if (rotationFactor % 10 == 0) {
                10
            } else {
                rotationFactor % 10
            }
        } else {
            rotationFactor
        }
        val stringBuilder = StringBuilder()
        for (c in input) {
            when {
                c.isLetter() -> {
                    stringBuilder.append(rotateCharacter(c, factorCharacter))
                }
                c.isDigit() -> {
                    stringBuilder.append(rotateNumber(c, factorNumber))
                }
                else -> {
                    stringBuilder.append(c)
                }
            }
        }
        return stringBuilder.toString()
    }

    private fun rotateCharacter(c: Char, rotationFactor: Int): Char {
        val startLetter = if (c.isUpperCase())'A' else 'a'
        return ((c - startLetter + rotationFactor) % 26).toChar() + startLetter.toInt()
    }

    private fun rotateNumber(c: Char, rotationFactor: Int): Char {
        return ((c - '0' + rotationFactor) % 10).toChar() + '0'.toInt()
    }
}