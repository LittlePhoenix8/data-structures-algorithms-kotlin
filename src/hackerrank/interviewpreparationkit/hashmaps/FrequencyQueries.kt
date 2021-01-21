package hackerrank.interviewpreparationkit.hashmaps

/**
 * https://www.hackerrank.com/challenges/frequency-queries/problem
 * */
fun main() {
    val frequencyQueries = FrequencyQueries()

    println(frequencyQueries.freqQuery(arrayOf(arrayOf(1, 5), arrayOf(1, 6), arrayOf(3, 2), arrayOf(1, 10),
            arrayOf(1, 10), arrayOf(1, 6), arrayOf(2, 5), arrayOf(3, 2))).joinToString(", "))
    //[0, 1]

    println(frequencyQueries.freqQuery(arrayOf(arrayOf(3, 4), arrayOf(2, 1003), arrayOf(1, 16), arrayOf(3, 1))).joinToString(", "))
    //[0, 1]

    println(frequencyQueries.freqQuery(arrayOf(arrayOf(1, 3), arrayOf(2, 3), arrayOf(3, 2), arrayOf(1, 4), arrayOf(1, 5),
            arrayOf(1, 5), arrayOf(1, 4), arrayOf(3, 2), arrayOf(2, 4), arrayOf(3, 2))).joinToString(", "))
    //[0, 1, 1]
}

class FrequencyQueries {
    fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
        //Create arrayList of options
        val elements = HashMap<Int, Int>()
        val results = ArrayList<Int>()
        val biggerRepetitions = HashMap<Int, Int>()
        //iterate the first Array
        queries.forEach {
            val operation = operate(it, elements, biggerRepetitions)
            if(operation != -1) {
                results.add(operation)
            }
        }
        return results.toTypedArray()
    }
    private fun operate(query: Array<Int>, elements: HashMap<Int, Int>, biggerRepetitions: HashMap<Int, Int>): Int {
        //query[0] = action
        when(query[0]) {
            1-> {
                //add element
                if(elements[query[1]] == null) {
                    elements[query[1]] = 0
                }
                elements[query[1]] = elements[query[1]]!! + 1
                processBigHashMap(elements[query[1]]!! - 1, elements[query[1]]!!, biggerRepetitions)
            }
            2-> {
                //delete element
                elements[query[1]]?.let{
                    if(it > 0) {
                        elements[query[1]] = it - 1
                        processBigHashMap(elements[query[1]]!! + 1, elements[query[1]]!! , biggerRepetitions)
                    }
                }
            }
            3-> {
                //check if element exist
                if(biggerRepetitions[query[1]] != null &&
                        biggerRepetitions[query[1]]!! > 0) {
                    //element exist
                    return  1
                }
                //element doesn't exist
                return  0
            }
        }
        return  -1
    }

    //oldRepetition previous value
    //newRepetition latest value
    private fun processBigHashMap(oldRepetition: Int, newRepetition: Int, countNumbers: HashMap<Int, Int>) {
        if(countNumbers[newRepetition] == null) {
            //if new number doesn't exist is 0
            countNumbers[newRepetition] = 0
        }
        //add +1 to new number
        countNumbers[newRepetition] = countNumbers[newRepetition]!! + 1
        //if old number exist & more than 0
        countNumbers[oldRepetition]?.let{
            if(it > 0) {
                //rest -1 to old number
                countNumbers[oldRepetition] = it - 1
            }
        }
    }
}