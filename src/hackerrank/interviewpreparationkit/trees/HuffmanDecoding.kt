package hackerrank.interviewpreparationkit.trees

import java.lang.StringBuilder

/**
 * https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 * */
fun main() {
    val huffmanDecoding = HuffmanDecoding()

    // | A |  B  | R  | A |  C   | A |   D  | A |  B  | R  | A |
    // | 0 | 111 | 10 | 0 | 1100 | 0 | 1101 | 0 | 111 | 10 | 0 |
    val root1 = NodeFrequency(11, null)
    val node1 = NodeFrequency(5, 'A')
    val node2 = NodeFrequency(6, null)
    val node3 = NodeFrequency(2, 'R')
    val node4 = NodeFrequency(4, null)
    val node5 = NodeFrequency(2, null)
    val node6 = NodeFrequency(2, 'B')
    val node7 = NodeFrequency(1, 'C')
    val node8 = NodeFrequency(11, 'D')
    root1.left = node1
    root1.right = node2
    node2.left = node3
    node2.right = node4
    node4.left = node5
    node4.right = node6
    node5.left = node7
    node5.right = node8
    huffmanDecoding.decode("01111001100011010111100", root1) //ABRACADABRA

    // | A | B  | A | C  | A |
    // | 1 | 00 | 1 | 01 | 1 |
    val root2 = NodeFrequency(5, null)
    val node9 = NodeFrequency(2, null)
    val node10 = NodeFrequency(3, 'A')
    val node11 = NodeFrequency(1, 'B')
    val node12 = NodeFrequency(1, 'C')
    root2.left = node9
    root2.right = node10
    node9.left = node11
    node9.right = node12
    huffmanDecoding.decode("1001011", root2) //ABACA
}

class HuffmanDecoding {
    fun decode(s: String?, root: NodeFrequency?) {
        if (root == null || s == null) {
            return
        }
        val stringBuilder = StringBuilder()
        var currentNode: NodeFrequency? = root
        for (letter in s) {
            val newNode: NodeFrequency? = if (letter == '0') {
                //left
                currentNode?.left
            } else {
                //right
                currentNode?.right
            }
            currentNode = if (newNode?.data != null) {
                //is leaf node, found letter
                stringBuilder.append(newNode.data)
                //go back to root
                root
            } else {
                //not lef, keep going down
                newNode
            }
        }
        println(stringBuilder.toString())
    }
}

class NodeFrequency(var frequency: Int, var data: Char?) {
    var left: NodeFrequency? = null
    var right: NodeFrequency? = null
}
