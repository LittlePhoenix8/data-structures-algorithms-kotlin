package pramp.found;

public class LargestSmallerBSTKey {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static int findLargestSmallerKey(int num, Node root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return root.value < num? root.value : -1;
        }
        int result = -1;
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value < num) {
                result = currentNode.value;
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        Node root = new Node(20);
        Node node1 = new Node(9);
        Node node2 = new Node(25);
        Node node3 = new Node(5);
        Node node4 = new Node(12);
        Node node5 = new Node(11);
        Node node6 = new Node(14);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        System.out.println(findLargestSmallerKey(17, root));
        System.out.println(findLargestSmallerKey(13, root));
    }
}
