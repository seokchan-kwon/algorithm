import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int n : people) {
            dq.add(n);
        }
        
        while (!dq.isEmpty()) {
            if (dq.peekFirst() + dq.peekLast() <= limit) {
                dq.pollLast();
                dq.pollFirst();
            } else {
                dq.pollLast();
            }
            answer++;
        }
        
        return answer;
    }
}