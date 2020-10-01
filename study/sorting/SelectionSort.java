public class SelectionSort {
    /**
     * 시간복잡도
     * Best : n^2
     * Average : n^2
     * Worst : n^2
     */

    private int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int i, int j) {
        int temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }

    private void selectionSort(int start) {
        if (start < this.arr.length - 1) {
            int min = this.arr[start];
            for (int i = start + 1; i < this.arr.length; ++i) {
                if (this.arr[i] < min) {
                    min = i;
                }
            }
            swap(start, min);
            selectionSort(start + 1);
        }
    }

    public int[] run() {
        this.selectionSort(0);
        return this.arr;
    }
}