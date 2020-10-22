package datastructures.trees

import com.google.gson.Gson

fun main() {
    val tree = BinarySearchTree()
    tree.insert(9)
    tree.insert(4)
    tree.insert(6)
    tree.insert(20)
    tree.insert(170)
    tree.insert(15)
    tree.insert(1)
    println(Gson().toJson(tree))

    println(tree.lookup(9)?.value)
    println(tree.lookup(20)?.value)
    println(tree.lookup(100)?.value)

    tree.remove(170)
    println(Gson().toJson(tree))
}

class BinarySearchTree {
    private var root: Node? = null

    fun insert(value: Int) {
        val newNode = Node(value)
        if (root == null) {
            root = newNode
        } else {
            var currentNode = root
            while (true) {
                if (value < currentNode!!.value) {
                    //left
                    if (currentNode.left == null) {
                        currentNode.left = newNode
                        return
                    } else {
                        currentNode = currentNode.left
                    }
                } else {
                    //right
                    if (currentNode.right == null) {
                        currentNode.right = newNode
                        return
                    } else {
                        currentNode = currentNode.right
                    }
                }
            }
        }
    }

    fun lookup(value: Int): Node? {
        return when {
            root == null -> {
                null
            }
            root!!.value == value -> {
                root
            }
            else -> {
                var currentNode = root
                while (currentNode != null) {
                    when {
                        value < currentNode.value -> {
                            //left
                            currentNode = currentNode.left
                        }
                        value > currentNode.value -> {
                            //right
                            currentNode = currentNode.right
                        }
                        value == currentNode.value -> {
                            return currentNode
                        }
                    }
                }
                return null
            }
        }
    }

    fun remove(value: Int) {
        if (root == null) {
            return
        }
        var currentNode = root
        var parentNode: Node? = null
        while(currentNode != null) {
            when {
                value < currentNode.value -> {
                    parentNode = currentNode
                    currentNode = currentNode.left
                }
                value > currentNode.value -> {
                    parentNode = currentNode
                    currentNode = currentNode.right
                }
                currentNode.value == value -> {
                    //We have a match, get to work!
                    //Option 1: No right child:
                    if (currentNode.right === null) {
                        if (parentNode === null) {
                            root = currentNode.left
                        } else {
                            //if parent > current value, make current left child a child of parent
                            if(currentNode.value < parentNode.value) {
                                parentNode.left = currentNode.left
                                //if parent < current value, make left child a right child of parent
                            } else if(currentNode.value > parentNode.value) {
                                parentNode.right = currentNode.left
                            }
                        }
                    //Option 2: Right child which doesnt have a left child
                    } else if (currentNode.right?.left === null) {
                        currentNode.right?.left = currentNode.left
                        if(parentNode === null) {
                            this.root = currentNode.right
                        } else {
                            //if parent > current, make right child of the left the parent
                            if(currentNode.value < parentNode.value) {
                                parentNode.left = currentNode.right

                                //if parent < current, make right child a right child of the parent
                            } else if (currentNode.value > parentNode.value) {
                                parentNode.right = currentNode.right
                            }
                        }
                    //Option 3: Right child that has a left child
                    } else {
                        //find the Right child's left most child
                        var leftmost: Node? = currentNode.right?.left
                        var leftmostParent: Node? = currentNode.right
                        while(leftmost?.left !== null) {
                            leftmostParent = leftmost
                            leftmost = leftmost.left
                        }

                        //Parent's left subtree is now leftmost's right subtree
                        leftmostParent?.left = leftmost?.right
                        leftmost?.left = currentNode.left
                        leftmost?.right = currentNode.right

                        if(parentNode === null) {
                            root = leftmost
                        } else {
                            if(currentNode.value < parentNode.value) {
                                parentNode.left = leftmost
                            } else if(currentNode.value > parentNode.value) {
                                parentNode.right = leftmost
                            }
                        }
                    }
                    return
                }
            }
        }
    }

    //Recursion
    fun insertWithRecursion(value: Int) {
        val newNode = Node(value)
        if (root == null) {
            root = newNode
        } else {
            insertWithRecursion(newNode, root!!)
        }
    }

    fun lookupWithRecursion(value: Int): Node? {
        return when {
            root == null -> {
                null
            }
            root!!.value == value -> {
                root
            }
            else -> {
                lookup(value, root!!)
            }
        }
    }

    private fun lookup(value: Int, parentNode: Node): Node? {
        if (value > parentNode.value) {
            if (parentNode.right == null) {
                return null
            } else {
                //lookup right
                if (parentNode.right!!.value == value) {
                    return parentNode.right
                } else {
                    lookup(value, parentNode.right!!)
                }
            }
        } else {
            if (parentNode.left == null) {
                return null
            } else {
                //lookup left
                if (parentNode.left!!.value == value) {
                    return parentNode.left
                } else {
                    lookup(value, parentNode.left!!)
                }
            }
        }
        return null
    }

    private fun insertWithRecursion(newNode: Node, parentNode: Node) {
        if (newNode.value > parentNode.value) {
            //insert right
            if (parentNode.right == null) {
                insertRight(newNode, parentNode)
            } else {
                insertWithRecursion(newNode, parentNode.right!!)
            }
        } else {
            //insert left
            if (parentNode.left == null) {
                insertLeft(newNode, parentNode)
            } else {
                insertWithRecursion(newNode, parentNode.left!!)
            }
        }
    }

    private fun insertRight(newNode: Node, parentNode: Node) {
        parentNode.right = newNode
    }

    private fun insertLeft(newNode: Node, parentNode: Node) {
        parentNode.left = newNode
    }
}

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}