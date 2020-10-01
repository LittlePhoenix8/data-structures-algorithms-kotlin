package bigo

fun main() {
    anotherFunChallenge(arrayOf(1, 2, 3, 4))
}

fun anotherFunChallenge(input: Array<Any>) {
    var a = 5 //O(1)
    var b = 10 //O(1)
    var c = 50 //O(1)
    for (i in input.indices) { //O(n)
        var x = i + 1 //O(n)
        var y = i + 2 //O(n)
        var z = i + 3 //O(n)
    }
    for (j in input.indices) { //O(n)
        var p = j * 2 //O(n)
        var q = j * 2 //O(n)
    }
    var whoAmI = "I don't know" //O(1)
}
//Big O(4 + 7n) -> O(n)