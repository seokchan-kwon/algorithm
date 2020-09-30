public class MergeSort {
    /**
     * 시간복잡도
     * Best : nlogn
     * Average : nlogn
     * Worst : nlogn
     */

    private int[] arr;
    
    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(this.arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(this.arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightARr[j]) {
                this.arr[k++] = leftArr[i++];
            } else {
                this.arr[k++] = rightArr[j++];
            }
        }

        while (i < leftLength) {
            this.arr[k++] = leftArr[i++];
        }

        while (j < rightLength) {
            this.arr[k++] = rightArr[j++];
        }
    }

    public int[] run() {
        mergeSort(0, this.arr.length - 1);
        return this.arr;
    }
}
