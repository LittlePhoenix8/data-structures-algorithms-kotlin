package bigo

fun main() {
    //find first and nth(latest)
    //O(1)
    val array = arrayOf("hi", "my", "teddy")
    val oldest = array[0] //O(1)
    val latest = array[array.size - 1] //O(1)

    //compare each tweet -> nested loop
    //O(n^2)
    val array2 = arrayOf(Tweet("hi", 2012), Tweet("my", 2014), Tweet("teddy", 2018))

    //Big O depends on language
    //O(1) in kotlin/java
    println("helwoshejhekhiuhudsh".length)
}

class Tweet(tweet: String, date: Int)