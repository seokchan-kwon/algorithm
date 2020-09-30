public class InsertionSort {
    /**
     * 시간복잡도
     * Best : n
     * Average : n^2
     * Worst : n^2
     */
    
    private int[] numbers;

    public InsertionSort(int[] numbers) {
        this.numbers = numbers;
    }

    private int[] insertionSort(int[] arr) {
        int i, j, num;
        for (i = 1; i < arr.length; ++i) {
            num = arr[i];
            j = i - 1;
            for (; j >= 0 && arr[j] > num; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = num;
        }
        return arr;
    }

    public int[] run() {
        return this.insertionSort(this.numbers);
    }
}
