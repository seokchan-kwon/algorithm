public class BubbleSort {
    /**
     * 시간복잡도
     * Best : n^2
     * Average : n^2
     * Worst : n^2
     */
    
    private int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    private void bubbleSort(int last) {
        if (last > 0) {
            for (int i = 1; i <= last; ++i) {
                if (this.arr[i - 1] > this.arr[i]) {
                    swap(i - 1, i);
                }
            }
            bubbleSort(last - 1);
        }
    }

    public int[] run() {
        return this.bubbleSort(this.arr.length - 1);
    }
}