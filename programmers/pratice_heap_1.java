import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) {
            pq.add(n);
        }
        
        if (pq.peek() >= K) {
            return 0;
        }
        
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
            
            if (pq.peek() >= K) {
                break;
            }
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}