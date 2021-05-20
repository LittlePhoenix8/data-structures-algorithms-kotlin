package lettcodeexercices.medium

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://leetcode.com/problems/simplify-path/submissions/
 * */
fun main() {
    val simplifyPath = SimplifyPath()
    println(simplifyPath.simplifyPath("/home/")) //"/home"
    println(simplifyPath.simplifyPath("/../")) //"/"
    println(simplifyPath.simplifyPath("/home//foo/")) //"/home/foo"
    println(simplifyPath.simplifyPath("/a/./b/../../c/")) //"/c"
}

class SimplifyPath {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        val paths = path.split("/")
        for (p in paths) {
            if (stack.isNotEmpty() && p =="..") {
                //move up directory
                stack.pop()
            } else if (p.isNotEmpty() && p != "." && p != "..") {
                stack.push(p)
            }
        }
        val directories = ArrayList<String>(stack)
        return "/${directories.joinToString("/")}"
    }
}