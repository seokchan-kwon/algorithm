public class BinarySearch {
    /**
     * 시간 복잡도 : O(logn)
     * 모든 값들이 정렬되어 있어야 한다.
     */

    private int[] arr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    // using loop
    private int binarySearch(int target) {
        int low = 0;
        int high = this.arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (this.arr[mid] == target) {
                return mid;
            } else if (this.arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // using recursion
    private int binarySearchRecursive(int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        
        if (this.arr[mid] == target) {
            return mid;
        } else if (this.arr[mid] > target) {
            return binarySearchRecursive(target, low, mid - 1);
        } else {
            return binarySearchRecursive(target, mid + 1, high);
        }
    }

    public int find(int target) {
        return this.binarySearch(target);
    }
}
