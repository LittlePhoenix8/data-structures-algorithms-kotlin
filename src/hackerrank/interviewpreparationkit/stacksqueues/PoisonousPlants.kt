package hackerrank.interviewpreparationkit.stacksqueues

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

/**
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 * */
fun main() {
    val poisonousPlants = PoisonousPlants()
    println(poisonousPlants.poisonousPlants(arrayOf(3, 6, 2, 7, 5))) //2
    println(poisonousPlants.poisonousPlants(arrayOf(6, 5, 8, 4, 7, 10, 9))) //2
}

class PoisonousPlants {
    fun poisonousPlants(p: Array<Int>): Int {
        val stack = Stack<Plant>()
        var maxDays = 0
        for (plant in p) {
            var day = 0
            while (stack.isNotEmpty() && stack.peek().p >= plant) {
                val pop = stack.pop()
                day = max(day, pop.day)
            }
            if (stack.isNotEmpty()) {
                day += 1
            } else {
                day = 0
            }
            maxDays = max(maxDays, day)
            stack.push(Plant(plant, day))
        }
        return maxDays
    }

    class Plant(var p: Int, val day: Int)

    fun poisonousPlantsBruteForce(p: Array<Int>): Int {
        if (p.isEmpty()) {
            return 1
        }
        if (p.size == 1) {
            return 1
        }
        val plantsLeft = ArrayList<Int>()
        plantsLeft.addAll(p)
        var days = 0
        var stillDying = true
        while (stillDying) {
            var deadPlants = 0
            val newPlans = ArrayList<Int>()
            for (i in plantsLeft.indices) {
                if (i - 1 >= 0 && plantsLeft[i] > plantsLeft[i - 1]) {
                    deadPlants++
                } else {
                    newPlans.add(plantsLeft[i])
                }
            }
            plantsLeft.clear()
            plantsLeft.addAll(newPlans)
            if (deadPlants == 0) {
                stillDying = false
            } else {
                days++
            }
        }
        return days
    }
}