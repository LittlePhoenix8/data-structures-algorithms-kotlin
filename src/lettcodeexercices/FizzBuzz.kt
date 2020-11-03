package lettcodeexercices

fun main() {
    val fizzBuzz = FizzBuzz()
    println(fizzBuzz.fizzBuzz(15))
}

class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val list = ArrayList<String>()
        for(i in 1..n) {
            if(i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz")
            } else if(i % 3 == 0) {
                list.add("Fizz")
            } else if(i % 5 == 0) {
                list.add("Buzz")
            } else {
                list.add("$i")
            }
        }
        return list
    }
}