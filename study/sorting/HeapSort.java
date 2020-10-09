public class HeapSort {
    /**
     * 시간복잡도
     * Best : nlogn
     * Average : nlogn
     * Worst : nlogn
     */

    private int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapify(int node, int size) {
        int parentNode = node;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;

        if (size > leftNode && arr[parentNode] < arr[leftNode]) {
            parentNode = leftNode;
        }
        if (size > rightNode && arr[parentNode] < arr[rightNode]) {
            parentNode = rightNode;
        }

        if (node != parentNode) {
            swap(node, parentNode);
            heapify(parentNode, size);
        }
    }

    public int[] getDescendingArray() {
        int[] lastArr = this.getAccendingArray();
        int[] newArr = new int[lastArr.length];
        for (int i = 0; i < lastArr.length; ++i) {
            newArr[i] = lastArr[lastArr.length - 1 - i];
        }
        return newArr;
    }

    public int[] getAccendingArray() {
        int length = this.arr.length;
        for (int i = length / 2 - 1; i >= 0; --i) {
            heapify(i, length);
        }
        for (int i = length - 1; i > 0; --i) {
            swap(0, i);
            heapify(0, i);
        }

        return this.arr;
    }
}
