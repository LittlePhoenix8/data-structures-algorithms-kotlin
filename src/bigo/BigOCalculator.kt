package bigo

fun main() {
    val array = arrayOf(1, 2, 3, 4)
    println(funChallenge(array))
}

fun funChallenge(input: Array<Int>): Int {
    var a = 10 //O(1)
    a = 50 + 3 //O(1)

    for (i in input.indices) { //O(n)
        anotherFunction() //O(n)
        val stranger = true //O(n)
        a++ //O(n)
    }
    return a //O(1)
}

//3 + n + n + n + n
//Big O(3 + 4n) -> O(n)

fun anotherFunction() {}