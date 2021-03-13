package pramp

import java.lang.StringBuilder

class WordCountEngineK {
    fun wordCountEngine(document: String): Array<Array<String>> {
        val wordMap = HashMap<String, Int>()
        val wordList = document.split(" ")
        var largestCount = 0

        for (i in wordList.indices) {
            //word in lowercase
            val word = wordList[i].toLowerCase()
            val stringBuilder = StringBuilder()
            for (ch in word) {
                //remove punctuation characters
                if (ch in 'a'..'z') {
                    stringBuilder.append(ch)
                }
            }
            //create word without punctuation
            val cleanWord = stringBuilder.toString()
            if (cleanWord.isEmpty()) {
                //if word is empty skip it
                continue
            }
            var count: Int
            if (wordMap.containsKey(cleanWord)) {
                //if word exist increment count
                count = wordMap[cleanWord]!!
                count++
            } else {
                //if word doesn't exist add with count 1
                count = 1
            }
            if (count > largestCount) {
                largestCount = count
            }
            wordMap[cleanWord] = count
        }
        val counterList = ArrayList<ArrayList<String>?>(largestCount + 1)
        for (i in 0 until largestCount + 1) {
            counterList.add(null)
        }

        for (word in wordMap.keys) {
            val counter = wordMap[word]!!
            var wordCounterList = counterList[counter]
            if (wordCounterList == null) {
                wordCounterList = ArrayList()
            }
            wordCounterList.add(word)
            counterList[counter] = wordCounterList
        }
        val result = ArrayList<Array<String>>()
        for (i in counterList.size - 1 downTo 0) {
            val wordCounterList = counterList[i] ?: continue
            val occurrence = i.toString()
            for (j in 0 until wordCounterList.size) {
                result.add(arrayOf(wordCounterList[j], occurrence))
            }
        }
        return result.toTypedArray()
    }
}

private fun printOutput(output: Array<Array<String>>) {
    for (strings in output) {
        println(strings[0] + " " + strings[1])
    }
    println("------")
}

fun main() {
    val wordCountEngineK = WordCountEngineK()
    //printOutput(wordCountEngineK.wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!"))
    printOutput(wordCountEngineK.wordCountEngine("Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!"))
    printOutput(wordCountEngineK.wordCountEngine("To be, or not to be, that is the question:"))
    printOutput(wordCountEngineK.wordCountEngine("Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. "))
    printOutput(wordCountEngineK.wordCountEngine("I have failed over and over and over again in my life and that is why I succeed."))
    printOutput(wordCountEngineK.wordCountEngine("Look If you had One shot, Or one opportunity, To seize everything you ever wanted, In one moment, Would you capture it, Or just let it slip?"))
    printOutput(wordCountEngineK.wordCountEngine("Cause I'm Slim Shady, yes I'm the real Shady, All you other Slim Shadys are just imitating So won't the real Slim Shady, please stand up, Please stand up, Please stand up"))
}
