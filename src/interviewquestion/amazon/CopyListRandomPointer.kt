package interviewquestion.amazon

import java.lang.StringBuilder

fun main() {
    val copyListRandomPointer = CopyListRandomPointer()

    val node0 = Node(7)
    val node1 = Node(13)
    val node2 = Node(11)
    val node3 = Node(10)
    val node4 = Node(1)

    node0.random = null
    node1.random = node0
    node2.random = node4
    node3.random = node2
    node4.random = node0

    node0.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = null

    val nodeCopy1 = copyListRandomPointer.copyRandomList(node0)
    println(node0.printNode()) //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    println(nodeCopy1?.printNode()) //[[7,null],[13,0],[11,4],[10,2],[1,0]]
}

class CopyListRandomPointer {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return null
        }
        var current = node
        val map = HashMap<Node, Node>()
        var result: Node?
        while (current != null) {
            result = map.getOrPut(current) { Node(current!!.`val`) }

            val next = if (current.next == null) {
                null
            } else {
                map.getOrPut(current.next!!) { Node(current!!.next!!.`val`)}
            }
            val random = if (current.random == null) {
                null
            } else {
                map.getOrPut(current.random!!) { Node(current!!.random!!.`val`) }
            }

            result.next = next
            result.random = random

            current = current.next
            //result = result.next
        }
        return map[node]
    }
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null

    fun printNode(): String {
        val stringBuilder = StringBuilder()
        var current: Node? = this
        while (current != null) {
            stringBuilder.append("[${current.`val`}, ${current.random?.`val`}]")
            current = current.next
        }
        return stringBuilder.toString()
    }
}