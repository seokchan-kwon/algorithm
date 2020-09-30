import java.util.*;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap(ArrayList<Integer> list) {
        if (list == null) {
            heap = new ArrayList<>();
            heap.add(1000000);
        } else {
            heap = list;
        }
    }

    public MaxHeap() {
        this(null);
    }

    public void insert(int num) {
        heap.add(num);
        int node = heap.size() - 1;
        
        while (node > 1 && heap.get(node / 2) < heap.get(node)) {
            int temp = heap.get(node / 2);
            heap.set(node / 2, heap.get(node));
            heap.set(node, temp);
            node /= 2;
        }
    }

    public int delete() {
        if (heap.size() < 2) {
            return 0;
        }

        int num = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1;
        while (pos * 2 < heap.size()) {
            int max = heap.get(pos * 2);
            int maxPos = pos * 2;

            if (maxPos + 1 < heap.size() && max < heap.get(maxPos + 1)) {
                max = heap.get(maxPos + 1);
                maxPos++;
            }

            if (heap.get(pos) > max) {
                break;
            }

            int temp = heap.get(pos);
            heap.set(pos, heap.get(maxPos));
            heap.set(maxPos, temp);
            pos = maxPos;
        }

        return num;
    }

    public ArrayList<Integer> getHeap() {
        return heap;
    }
}
