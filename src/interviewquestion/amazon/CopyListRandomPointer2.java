package interviewquestion.amazon;

import java.util.HashMap;

public class CopyListRandomPointer2 {
    public static void main(String[]args){
        CopyListRandomPointer2 copyListRandomPointer2 = new CopyListRandomPointer2();

        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.setRandom(null);
        node1.setRandom(node0);
        node2.setRandom(node4);
        node3.setRandom(node2);
        node4.setRandom(node0);

        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);

        Node nodeCopy1 = copyListRandomPointer2.copyRandomList(node0);
        System.out.println(node0.printNode()); //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        System.out.println(nodeCopy1.printNode()); //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        HashMap<Node, Node> map = new HashMap<>();
        Node result;
        while (current != null) {
            if (!map.containsKey(current)) {
                map.put(current, new Node(current.getVal()));
            }
            result = map.get(current);

            Node next;
            if (current.getNext() == null) {
                next = null;
            } else {
                if (!map.containsKey(current.getNext())) {
                    map.put(current.getNext(), new Node(current.getNext().getVal()));
                }
                next = map.get(current.getNext());
            }
            Node random;
            if (current.getRandom() == null) {
                random = null;
            } else {
                if (!map.containsKey(current.getRandom())) {
                    map.put(current.getRandom(), new Node(current.getRandom().getVal()));
                }
                random = map.get(current.getRandom());
            }

            if (result != null) {
                result.setNext(next);
                result.setRandom(random);
            }
            current = current.getNext();
            //result = result.getNext();
        }
        return map.get(head);
    }
}
