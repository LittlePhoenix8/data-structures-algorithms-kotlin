package hackerrank.interviewpreparationkit.arrays

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * */
fun main() {
    val arrayManipulation = ArrayManipulation()
    val array1 = arrayOf(1, 2, 100)
    val array2 = arrayOf(2, 5, 100)
    val array3 = arrayOf(3, 4, 100)
    println(arrayManipulation.arrayManipulation(5, arrayOf(array1, array2, array3))) //200

    val array4 = arrayOf(1, 5, 3)
    val array5 = arrayOf(4, 8, 7)
    val array6 = arrayOf(6, 9, 1)
    println(arrayManipulation.arrayManipulation(10, arrayOf(array4, array5, array6))) //10

    val array7 = arrayOf(2, 6, 8)
    val array8 = arrayOf(3, 5, 7)
    val array9 = arrayOf(1, 8, 1)
    val array10 = arrayOf(5, 9, 15)
    println(arrayManipulation.arrayManipulation(10, arrayOf(array7, array8, array9, array10))) //31
}

class ArrayManipulation {
    fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        var sum : Long = 0
        val map = arrayOfNulls<ElementTest>(n)
        for(i in queries) {
            val start  = i[0] - 1
            val end = i[1] - 1
            map[start]?.let{
                map[start]!!.start += i[2]
            }?:run{
                map[start] = ElementTest(i[2],0)
            }
            map[end]?.let{
                map[end]!!.end += i[2]
            }?:run{
                map[end] = ElementTest(0, i[2])
            }
        }
        var current: Long = 0
        for(elements in map) {
            elements?.let{
                current += it.start
                if(current > sum) {
                    sum = current
                }
                current -= it.end
            }
        }
        return sum
    }
}
class ElementTest(var start: Int, var end: Int)