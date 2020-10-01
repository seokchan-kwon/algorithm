public class Bst {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    int[] arr;
    Node root;

    public Bst(int[] arr) {
        this.arr = arr;
    }

    private Node makeTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeTree(arr, start, mid - 1);
        node.right = makeTree(arr, mid + 1, end);

        return node;
    }

    private void treeToList(Node n, ArrayList<Integer> list) {
        if (n == null) {
            return;
        }
        list.add(n.data);
        treeToArray(n.left, list);
        treeToArray(n.right, list);
    }

    public ArrayList<Integer> run() {
        this.root = this.makeTree(this.arr, 0, arr.length - 1);
        ArrayList<Integer> list = new ArrayList<>();
        treeToArray(this.root, list);
        return list;
    }
}