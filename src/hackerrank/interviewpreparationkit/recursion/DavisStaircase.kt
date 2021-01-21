package hackerrank.interviewpreparationkit.recursion

/**
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 * */
fun main() {
    val davisStaircase = DavisStaircase()
    println(davisStaircase.stepPerms(3)) //4
    println(davisStaircase.stepPerms(1)) //1
    println(davisStaircase.stepPerms(3)) //4
    println(davisStaircase.stepPerms(7)) //44
    println(davisStaircase.stepPerms(2)) //2
    println(davisStaircase.stepPerms(5)) //13
    println(davisStaircase.stepPerms(8)) //81
}

class DavisStaircase {
    fun stepPerms(n: Int): Int {
        val hashMap = HashMap<Int, Int>()
        if(n < 0) {
            return 0
        }
        if(n == 1) {
            return 1
        }
        if(n == 2) {
            return 2
        }
        if(n == 3) {
            return 4
        }
        if(!hashMap.containsKey(n)) {
            hashMap[n] = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3)
        }
        return hashMap[n]!!
    }
}