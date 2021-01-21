package hackerrank.interviewpreparationkit.sorting

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 * */
fun main() {
    val fraudulentActivityNotifications = FraudulentActivityNotifications()
    println(fraudulentActivityNotifications.activityNotifications(arrayOf(10, 20, 30, 40, 50), 3)) //1
    println(fraudulentActivityNotifications.activityNotifications(arrayOf(1, 2, 3, 4, 4), 4)) //0
    println(fraudulentActivityNotifications.activityNotifications(arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5)) //2
}

class FraudulentActivityNotifications {
    fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
        var notifications = 0
        val expenses = IntArray(201)
        for (i in 0 until d) {
            expenses[expenditure[i]]++
        }
        for (i in d until expenditure.size) {
            val median: Double = getMedian(d, expenses)
            if (expenditure[i] >= 2 * median) {
                notifications++
            }
            expenses[expenditure[i]]++
            expenses[expenditure[i - d]]--
        }
        return notifications
    }

    private fun getMedian(d: Int, data: IntArray): Double {
        var median = 0.0
        if (d % 2 == 0) {
            //even
            var m1: Int? = null
            var m2: Int? = null
            var count = 0
            for (j in data.indices) {
                count += data[j]
                if (m1 == null && count >= d / 2) {
                    m1 = j
                }
                if (m2 == null && count >= d / 2 + 1) {
                    m2 = j
                    break
                }
            }
            median = (m1!! + m2!!) / 2.0
        } else {
            //odd
            var count = 0
            for (j in data.indices) {
                count += data[j]
                if (count > d / 2) {
                    median = j.toDouble()
                    break
                }
            }
        }
        return median
    }
}