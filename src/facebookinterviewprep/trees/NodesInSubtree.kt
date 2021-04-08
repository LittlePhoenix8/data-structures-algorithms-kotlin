package facebookinterviewprep.trees

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

/**
 * Nodes in a Subtree
 * You are given a tree that contains N nodes, each containing an integer u which corresponds to a lowercase character
 * c in the string s using 1-based indexing.
 * You are required to answer Q queries of type [u, c], where u is an integer and c is a lowercase letter. The query
 * result is the number of nodes in the subtree of node u containing c.
 * Signature
 * int[] countOfNodes(Node root, ArrayList<Query> queries, String s)
 * Input
 * A pointer to the root node, an array list containing Q queries of type [u, c], and a string s
 * Constraints
 * N and Q are the integers between 1 and 1,000,000
 * u is a unique integer between 1 and N
 * s is of the length of N, containing only lowercase letters
 * c is a lowercase letter contained in string s
 * Node 1 is the root of the tree
 * Output
 * An integer array containing the response to each query
 * Example
 *    1(a)
 *   /   \
 * 2(b)  3(a)
 * s = "aba"
 * RootNode = 1
 * query = [[1, 'a']]
 * Note: Node 1 corresponds to first letter 'a', Node 2 corresponds to second letter of the string 'b', Node 3
 * corresponds to third letter of the string 'a'.
 * output = [2]
 * Both Node 1 and Node 3 contain 'a', so the number of nodes within the subtree of Node 1 containing 'a' is 2.
 * */
fun main() {
    NodesInSubtree().run()
}

class NodesInSubtree {
    private fun countOfNodes(root: Node, queries: ArrayList<Query>, s: String): Array<Int> {
        val result = Array(queries.size) { 0 }
        for(i in queries.indices) {
            val search = queries[i]
            var count = 0
            val list = LinkedList<ArrayList<Node>>()
            if(root.value == search.u) {
                if(s[i] == search.c) {
                    count++
                }
                list.add(root.children)
                count += countNodes(list, s, search.c)
            } else {
                for (kid in root.children) {
                    if (kid.value == search.u) {
                        if (s[kid.value - 1] == search.c) {
                            count++
                        }
                        list.add(kid.children)
                        break
                    }
                }
                count += countNodes(list, s, search.c)
            }
            result[i] = count
        }
        return result
    }

    private fun countNodes(list: LinkedList<ArrayList<Node>>, s: String, c: Char): Int {
        var count = 0
        while(list.isNotEmpty()) {
            val pop = list.pop()
            for (node in pop) {
                if (s[node.value - 1] == c) {
                    count++
                }
                if (node.children.isNotEmpty()) {
                    list.add(node.children)
                }
            }
        }
        return count
    }

    class Node {
        var value: Int
        var children: ArrayList<Node>
        constructor() {
            value = 0
            children = ArrayList()
        }
        constructor(_val: Int) {
            value = _val
            children = ArrayList()
        }
        constructor(_val: Int, _children: ArrayList<Node>) {
            value = _val
            children = _children
        }
    }

    class Query(var u: Int, var c: Char)

    var testCaseNumber = 1
    private fun check(expected: Array<Int>, output: Array<Int>) {
        val expectedSize = expected.size
        val outputSize = output.size
        var result = true
        if (expectedSize != outputSize) {
            result = false
        }
        val min = min(expectedSize, outputSize)
        for (i in 0 until min) {
            result = (output[i] == expected[i])
        }
        val rightTick = '\u2713'
        val wrongTick = '\u2717'
        if (result) {
            println("$rightTick Test #$testCaseNumber")
        } else {
            print("$wrongTick Test #$testCaseNumber: Expected ")
            printIntegerArray(expected)
            print(" Your output: ")
            printIntegerArray(output)
            println()
        }
        testCaseNumber++
    }

    private fun printIntegerArray(arr: Array<Int>) {
        print("[")
        for (i in arr.indices) {
            if (i != 0) {
                print(", ")
            }
            print(arr[i])
        }
        print("]")
    }

    fun run() {
        //Testcase 1
        val s1 = "aba"
        val root1 = Node(1)
        root1.children.add(Node(2))
        root1.children.add(Node(3))
        val queries1 = ArrayList<Query>()
        queries1.add(Query(1, 'a'))
        val output1 = countOfNodes(root1, queries1, s1)
        val expected1 = arrayOf(2)
        check(expected1, output1)

        // Testcase 2
        val s2 = "abaacab"
        val root2 = Node(1)
        root2.children.add(Node(2))
        root2.children.add(Node(3))
        root2.children.add(Node(7))
        root2.children[0].children.add(Node(4))
        root2.children[0].children.add(Node(5))
        root2.children[1].children.add(Node(6))
        val queries2 = ArrayList<Query>()
        queries2.add(Query(1, 'a'))
        queries2.add(Query(2, 'b'))
        queries2.add(Query(3, 'a'))
        val output2 = countOfNodes(root2, queries2, s2)
        val expected2 = arrayOf(4, 1, 2)
        check(expected2, output2)
    }
}