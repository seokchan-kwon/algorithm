import java.util.*;
class Solution {
    class Parse {
        int priority;
        int location;
        public Parse(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Deque<Parse> dq = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; ++i) {
            Parse p = new Parse(priorities[i], i);
            dq.add(p);
        }
        
        int answer = 0;
        while (!dq.isEmpty()) {
            Parse p = dq.peek();
            if (isMax(p.priority, dq)) {
                if (p.location == location) {
                    answer++;
                    break;
                } else {
                    dq.poll();
                    answer++;
                } 
            } else {
                dq.poll();
                dq.addLast(p);
            }
        }
        
        return answer;
    }
    
    public boolean isMax(int priority, Deque<Parse> dq) {
        int max = 0;
        for (Parse p : dq) {
            if (max < p.priority) {
                max = p.priority;
            }
        }
        
        return max == priority ? true : false;
    }
}