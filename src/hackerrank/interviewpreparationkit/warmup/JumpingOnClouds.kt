package hackerrank.interviewpreparationkit.warmup

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 * */
fun main() {
    val jumpingOnClouds = JumpingOnClouds()
    println(jumpingOnClouds.jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 0))) //4
    println(jumpingOnClouds.jumpingOnClouds(arrayOf(0, 0, 0, 1, 0, 0))) //3
}

class JumpingOnClouds {
    fun jumpingOnClouds(c: Array<Int>): Int {
        var jumps = 0
        val total = c.size - 1
        var indice = 0
        while(indice < total) {
            val cloud = c[indice]
            if (indice + 1 <= total) {
                if (indice + 2 <= total && c[indice + 1] == 0 && c[indice + 2] == 0) {
                    jumps += 1
                    indice += 2
                } else if (c[indice + 1] == 0) {
                    //normal
                    jumps += 1
                    indice += 1
                } else if (c[indice + 1] == 1) {
                    jumps += 1
                    indice += 2
                } else {
                    indice += 1
                }
            }
        }
        return jumps
    }
}