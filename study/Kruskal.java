import java.util.*;

class Kruskal {
    class Data implements Comparable<Data> {
        int start;
        int end;
        int cost;
        
        public Data(int start, int end, int cost) {
            super();
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data data) {
            return data.cost >= this.cost ? -1 : 1;
        }
    }

    private int n;
    private int e;
    private int[][] graph;
    private int[] parent;
    private int result;
    private PriorityQueue<Data> pq;

    /**
     * 
     * @param n 정점의 개수
     * @param e 간선의 개수
     * @param graph [][0] : start, [][1] : end, [][2] : cost
     */
    public Kruskal(int n, int e, int[][] graph) {
        this.n = n;
        this.e = e;
        this.graph = graph;
    }

    public int run() {
        parent = new int[n + 1];
        result = 0;
        pq = new PriorityQueue<Data>();
        
        for (int i = 0; i < graph.length; ++i) {
            pq.add(new Data(graph[i][0], graph[i][1], graph[i][2]));
        }

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < e; ++i) {
            Data data = pq.poll();
            int start = data.start;
            int end = data.end;

            if (find(start) == find(end)) {
                continue;
            }

            union(start, end);
            result += data.cost;
        }

        return result;
    }

    private int find(int index) {
        if (index == parent[index]) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }

    private void union(int first, int second) {
        int firstRoot = find(first);
        int secondRoot = find(second);

        if (firstRoot != secondRoot) {
            parent[firstRoot] = second;
        }
    }
}