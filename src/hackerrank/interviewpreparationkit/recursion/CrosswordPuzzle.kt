package hackerrank.interviewpreparationkit.recursion

import java.util.*

/**
 * https://www.hackerrank.com/challenges/crossword-puzzle/problem
 * */
fun main() {
    val crosswordPuzzle = CrosswordPuzzle()
    val crossword = arrayOf("+-++++++++", "+-++++++++", "+-++++++++", "+-----++++", "+-+++-++++", "+-+++-++++",
            "+++++-++++", "++------++", "+++++-++++", "+++++-++++")
    crosswordPuzzle.crosswordPuzzle(crossword, "LONDON;DELHI;ICELAND;ANKARA")
}

class CrosswordPuzzle {
    private var solved = false

    fun crosswordPuzzle(crossword: Array<String>, words: String) {
        tryToFit(crossword, LinkedList(words.split(";")))
    }

    private fun tryToFit(crossword: Array<String>, words: LinkedList<String>) {
        if (words.size == 0) {
            if(!solved) {
                println(crossword.joinToString("\n"))
            }
            solved = true
            return
        }
        positions(crossword, words.pop()).also {
            it.second.forEach { tuple ->
                put(crossword, it.first, tuple)
                tryToFit(crossword, words)
                revert(crossword, it.first, tuple)
            }
            words.push(it.first)
        }
    }

    private fun positions(crossword: Array<String>, word: String): Pair<String, MutableList<Triple<Int, Int, Boolean>>> {
        val positions = mutableListOf<Triple<Int, Int, Boolean>>()
        //Horizontal axis
        for (i in crossword.indices) {
            for (j in 0 .. (crossword[i].length - word.length)) {
                var isGood = true
                for (z in word.indices) {
                    if (crossword[i][j + z] !in arrayOf('-', word[z])) {
                        isGood = false
                        break
                    }
                }
                isGood && positions.add(Triple(i, j, false))
            }
        }
        //Vertical axis
        for (i in 0 .. (crossword.size - word.length)) {
            for (j in crossword[i].indices) {
                var isGood = true
                for (z in word.indices) {
                    if (crossword[i + z][j] !in arrayOf('-', word[z])) {
                        isGood = false
                        break
                    }
                }
                isGood && positions.add(Triple(i, j, true))
            }
        }
        return (word to positions)
    }

    private fun put(crossword: Array<String>, word: String, position: Triple<Int, Int, Boolean>) {
        //Vertical axis
        if (position.third) {
            word.forEachIndexed { index, c ->
                crossword[position.first + index].also {
                    crossword[position.first + index] = crossword[position.first + index].toCharArray().also {
                        it[position.second] = c
                    }.joinToString("")
                }
            }
        }
        //Horizontal axis
        else {
            crossword[position.first].also {
                word.forEachIndexed { index, c ->
                    crossword[position.first] = crossword[position.first].toCharArray().also {
                        it[index + position.second] = c
                    }.joinToString("")
                }
            }
        }
    }

    private fun revert(crossword: Array<String>, word: String, position: Triple<Int, Int, Boolean>) {
        //Vertical axis
        if (position.third) {
            word.forEachIndexed { index, _ ->
                crossword[position.first + index].also {
                    crossword[position.first + index] = crossword[position.first + index].toCharArray().also {
                        it[position.second] = '-'
                    }.joinToString("")
                }
            }
        }
        //Horizontal axis
        else {
            word.forEachIndexed { index, _ ->
                crossword[position.first].also {
                    crossword[position.first] = crossword[position.first].toCharArray().also {
                        it[index + position.second] = '-'
                    }.joinToString("")
                }
            }
        }
    }
}