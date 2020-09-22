import java.util.*;
class Solution {
    class Kruskal implements Comparable<Kruskal> {
        int start;
        int end;
        int cost;
        
        public Kruskal(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Kruskal k) {
            return k.cost >= this.cost ? -1 : 1;
        }
    }
    
    public int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Kruskal> pq = new PriorityQueue<>();
        parent = new int[n];
        
        for (int i = 0; i < costs.length; ++i) {
            pq.add(new Kruskal(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        for (int i = 0; i < costs.length; ++i) {
            Kruskal k = pq.poll();
            if (find(k.start) == find(k.end)) {
                continue;
            }
            
            union(k.start, k.end);
            answer += k.cost;
        }
        
        return answer;
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