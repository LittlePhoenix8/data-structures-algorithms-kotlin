package bigo

fun main() {
    boooo(5)
    arrayOfHiNTimes(6)
}

//Time complexity O(n)
//Space complexity O(1)
fun boooo(n: Int) {
    for (i in 0 until n) {
        println("booooo")
    }
}

//Time complexity O(n)
//Space complexity O(n)
fun arrayOfHiNTimes(n: Int): Array<String> {
    val hiArray = Array(n) { "" }
    for (i in 0 until n) {
        hiArray[i] = "hi"
    }
    return hiArray
}