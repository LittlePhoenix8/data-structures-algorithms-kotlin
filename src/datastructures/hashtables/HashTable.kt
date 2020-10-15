package datastructures.hashtables

import kotlin.collections.ArrayList

fun main() {
    val myMashTable = HashTable(50)
    myMashTable.set("grapes", 10000)
    myMashTable.set("apples", 54)
    myMashTable.set("oranges", 2)
    println(myMashTable.get("grapes"))
    println(myMashTable.get("apples"))
    println(myMashTable.get("oranges"))
    println(myMashTable.keys())
    println(myMashTable.keysWithoutCollisions())
}

class HashTable(size: Int) {
    private var data: Array<AnyKeyValueList> = Array(size) { AnyKeyValueList() }

    private fun hash(key: String): Int {
        var hash = 0
        for(i in key.indices) {
            hash = (hash + key[i].hashCode() * i) % data.size
        }
        return hash
    }

    fun set(key: String, value: Any) {
        val address = hash(key)
        if (data[address].isNullOrEmpty()) {
            data[address] = AnyKeyValueList()
        }
        data[address].add(AnyKeyValue(key, value))
    }

    fun get(key: String): Any? {
        val address = hash(key)
        val currentBucket = data[address]
        if (!currentBucket.isNullOrEmpty()) {
            for (current in currentBucket) {
                if (current.key == key) {
                    return current.value
                }
            }
        }
        return null
    }

    fun keys(): ArrayList<String> {
        val keys = ArrayList<String>()
        for (list in data) {
            if (!list.isNullOrEmpty()) {
                keys.add(list.first().key)
            }
        }
        return keys
    }

    fun keysWithoutCollisions(): ArrayList<String>? {
        if (data.isNullOrEmpty()) {
            return null
        }
        val result = ArrayList<String>()
        // loop through all the elements
        for (i in data.indices) {
            // if it's not an empty memory cell
            if (!data[i].isNullOrEmpty()) {
                // but also loop through all the potential collisions
                if (this.data.size > 1) {
                    for (j in data[i].indices) {
                        result.add(data[i][j].key)
                    }
                } else {
                    result.add(data[i].first().key)
                }
            }
        }
        return result
    }
}

class AnyKeyValueList: ArrayList<AnyKeyValue>()

class AnyKeyValue(var key: String, var value: Any)