import java.util.*;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap(ArrayList<Integer> list) {
        if (list == null) {
            heap = new ArrayList<>();
            heap.add(0);
        } else {
            heap = list;
        }
    }

    public MinHeap() {
        this(null);
    }

    public void insert(int num) {
        heap.add(num);
        int node = heap.size() - 1;
        
        while (node > 1 && heap.get(node / 2) > heap.get(node)) {
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
            int min = heap.get(pos * 2);
            int minPos = pos * 2;

            if (minPos + 1 < heap.size() && min > heap.get(minPos + 1)) {
                min = heap.get(minPos + 1);
                minPos++;
            }

            if (heap.get(pos) < min) {
                break;
            }

            int temp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, temp);
            pos = minPos;
        }

        return num;
    }

    public ArrayList<Integer> getHeap() {
        return heap;
    }
}
