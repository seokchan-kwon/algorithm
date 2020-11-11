import java.util.*;

public class Graph {
    class Node {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; ++i) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfsWithStack(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node n : node.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            System.out.println("visit : " + node.data);
        }
    }

    void bfsWithQueue(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            for (Node n : node.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            System.out.println("visit : " + node.data);
        }
    }

    void dfsWithRecursive(Node node) {
        if (node == null) {
            return;
        }
        node.marked = true;
        System.out.println("visit : " + node.data);
        
        for (Node n : node.adjacent) {
            if (!n.marked) {
                dfsWithRecursive(n);
            }
        }
    }
}
