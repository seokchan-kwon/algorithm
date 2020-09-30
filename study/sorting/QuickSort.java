public class QuickSort {
    /**
     * 시간복잡도
     * Best : nlogn
     * Average : nlogn
     * Worst : n^2
     */

    private int[] numbers;

    public QuickSort(int[] numbers) {
        this.numbers = numbers;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int num = arr[start];
                arr[start] = arr[end];
                arr[end] = num;
                start++;
                end--;
            }
        }
        return start;
    }

    private int[] quickSort(int[] arr, int start, int end) {
        int p = partition(arr, start, end);
        if (start < p - 1) {
            quickSort(arr, start, p - 1);
        }
        if (p < end) {
            quickSort(arr, p, end);
        }
        return arr;
    }

    public int[] run() {
        return quickSort(this.numbers, 0, this.numbers.length - 1);
    }
}
