package hackerrank.interviewpreparationkit.warmup

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 * */
fun main() {
    val countingValleys = CountingValleys()
    println(countingValleys.countingValleys(8, "UDDDUDUU")) //1
    println(countingValleys.countingValleys(12, "DDUUDDUDUUUD")) //2
}

class CountingValleys {
    fun countingValleys(n: Int, s: String): Int {
        var valleys = 0
        var countStep = 0
        val steps = s.toCharArray()
        for(step in steps.indices) {
            val previous = countStep
            if(steps[step] == 'D') {
                countStep -= 1
            } else if(steps[step] == 'U') {
                countStep += 1
            }
            if(previous < 0 && countStep == 0) {
                valleys += 1
            }
        }
        return valleys
    }
}