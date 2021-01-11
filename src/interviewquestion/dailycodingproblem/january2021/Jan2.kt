package interviewquestion.dailycodingproblem.january2021

/**
 * This problem was asked by Two Sigma.
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
 * implement a function rand7() that returns an integer from 1 to 7 (inclusive).
 * */
fun main() {
    println(rand7())
    println(rand7())
    println(rand7())
    println(rand7())
    println(rand7())
    println(rand7())
    println(rand7())
}

fun rand7(): Int {
    var s = 0
    var c = 7
    while (c-- > 0) {
        s += rand5()
    }
    return s % 7 + 1
}

fun rand5(): Int {
    return kotlin.random.Random.nextInt(1, 5)
}