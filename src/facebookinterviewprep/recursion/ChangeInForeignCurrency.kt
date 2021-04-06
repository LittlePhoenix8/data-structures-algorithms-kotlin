package facebookinterviewprep.recursion

import java.util.*

/**
 * Change in a Foreign Currency
 * You likely know that different currencies have coins and bills of different denominations. In some currencies, it's
 * actually impossible to receive change for a given amount of money. For example, Canada has given up the 1-cent penny.
 * If you're owed 94 cents in Canada, a shopkeeper will graciously supply you with 95 cents instead since there exists
 * a 5-cent coin.
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of
 * money targetMoney. Both the denominations and target amount will be given in generic units of that currency.
 * Signature
 * boolean canGetExactChange(int targetMoney, int[] denominations)
 * Input
 * 1 ≤ |denominations| ≤ 100
 * 1 ≤ denominations[i] ≤ 10,000
 * 1 ≤ targetMoney ≤ 1,000,000
 * Output
 * Return true if it's possible to receive exactly targetMoney given the available denominations, and false if not.
 * Example 1
 * denominations = [5, 10, 25, 100, 200]
 * targetMoney = 94
 * output = false
 * Every denomination is a multiple of 5, so you can't receive exactly 94 units of money in this currency.
 * Example 2
 * denominations = [4, 17, 29]
 * targetMoney = 75
 * output = true
 * You can make 75 units with the denominations [17, 29, 29].
 * */
fun main() {
    val changeInForeignCurrency = ChangeInForeignCurrency()
    println("iterative")
    println(changeInForeignCurrency.canGetExactChange(94, arrayOf(5, 10, 25, 100, 200))) //false
    println(changeInForeignCurrency.canGetExactChange(75, arrayOf(4, 17, 29))) //true
    println("recursive")
    println(changeInForeignCurrency.canGetExactChangeRecursive(94, arrayOf(5, 10, 25, 100, 200))) //false
    println(changeInForeignCurrency.canGetExactChangeRecursive(75, arrayOf(4, 17, 29))) //true
    println("treemap")
    println(changeInForeignCurrency.canGetExactChangeTreeMap(94, arrayOf(5, 10, 25, 100, 200))) //false
    println(changeInForeignCurrency.canGetExactChangeTreeMap(75, arrayOf(4, 17, 29))) //true
}

class ChangeInForeignCurrency {
    fun canGetExactChange(target: Int, denominations: Array<Int>): Boolean {
      var rest = target
      for(i in denominations.size - 1 downTo 0) {
        while(rest >= denominations[i]) {
          rest -= denominations[i]
        }
      }
      return rest == 0
    }

    fun canGetExactChangeRecursive(target: Int, denominations: Array<Int>): Boolean {
        var rest = target
        for(i in denominations.size - 1 downTo 0) {
            rest = getChange(rest, denominations[i])
        }
        return rest == 0
    }

    private fun getChange(target: Int, deno: Int): Int {
        if(target < deno) {
            return target
        }
        return getChange(target - deno, deno)
    }

    fun canGetExactChangeTreeMap(target: Int, denominations: Array<Int>): Boolean {
        val mem = TreeMap<Int, Boolean>()
        for (den in denominations) {
            mem[den] = true
        }
        return canGetExactChange(target, denominations, mem)
    }

    private fun canGetExactChange(target: Int, denominations: Array<Int>, mem: TreeMap<Int, Boolean>): Boolean {
        if (mem.contains(target)) {
            return true
        }
        val floorEntry = mem.floorEntry(target)
        if (floorEntry == null) {
            mem[target] = false
            return false
        }
        val diff = target - floorEntry.key
        if (diff == 0) {
            mem[target] = true
            return true
        }
        val result = canGetExactChange(diff, denominations, mem)
        mem[diff] = result
        return result
    }
}