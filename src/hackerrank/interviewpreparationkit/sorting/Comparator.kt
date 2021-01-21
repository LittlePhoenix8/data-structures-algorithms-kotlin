package hackerrank.interviewpreparationkit.sorting

import java.util.Arrays

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 * */
fun main() {
    val players = arrayOf(Player("amy", "100"), Player("david", "100"),
            Player("heraldo", "50"), Player("aakansha", "75"),
            Player("aleksa", "150"))
    val checker = Checker()
    Arrays.sort(players, checker)
    for (player in players) {
        println("${player.name}, ${player.score}")
    }
}

class Player(var name: String, var score: String)

class Checker: Comparator<Player> {
    // complete this method
    override fun compare(a: Player, b: Player): Int {
        if (a.score == b.score) {
            //if a = b = 0
            return if (a.name === b.name) {
                0
            } else compareByName(a.name, b.name)
        }
        return if (a.score > b.score) {
            //if a > b = 1
            -1
        } else {
            //if a < b = -1
            1
        }
    }

    //orden in ascending order by name
    private fun compareByName(nameA: String, nameB: String): Int {
        //if a < b = -1
        //if a = b = 0
        //if a > b = 1
        val compare = nameA.compareTo(nameB)
        return when {
            compare > 0 -> {
                //antes
                1
            }
            compare < 0 -> {
                //después
                -1
            }
            else -> {
                0
            }
        }
    }
}