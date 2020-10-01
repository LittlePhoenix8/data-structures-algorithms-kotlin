package bigo

fun main() {
    val nemo = arrayOf("nemo")
    val everyone = arrayOf("dory", "bruce", "marlin", "nemo", "gill", "bloat", "nigel", "squirt", "darla", "hank")
    val large = Array(10000) { "nemo" }
    findNemo(nemo) //O(1)
    findNemo(everyone) //O(10)
    findNemo(large) //O(10000)
}

//O(n) -> Linear Time
fun findNemo(array: Array<String>) {
    //val t0 = System.currentTimeMillis()
    for (i in array.indices) {
        //println("running")
        if (array[i] == "nemo") {
            println("Found Nemo")
            break
        }
    }
    //val t1 = System.currentTimeMillis()
    //val time = (t1 - t0)
    //println("Call to find nemo took $time milliseconds")
}