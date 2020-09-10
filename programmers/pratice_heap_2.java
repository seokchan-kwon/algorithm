import java.util.*;
class Solution {
    class Work implements Comparable<Work> {
        int inputTime;
        int workload;
        
        public Work(int inputTime, int workload) {
            this.inputTime = inputTime;
            this.workload = workload;
        }
        
        public boolean isStartable(int time) {
            return time < this.inputTime ? false : true;
        }
        
        @Override
        public int compareTo(Work w) {
            if (this.workload < w.workload) {
                return -1;
            } else {
                return 1;
            }
        }
    } 
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        List<Work> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; ++i) {
            list.add(new Work(jobs[i][0], jobs[i][1]));
        }
        
        list.sort(new Comparator<Work>(){
            @Override
            public int compare(Work w1, Work w2) {
                Integer input1 = new Integer(w1.inputTime);
                Integer input2 = new Integer(w2.inputTime);
                return input1.compareTo(input2);
            }
        });
        
        answer = list.get(0).workload;
        time = answer;
        list.remove(0);
        while (list.size() > 0) {
            PriorityQueue<Work> pq = new PriorityQueue<>();
            for (Work w : list) {
                if (w.isStartable(time)) {
                    pq.add(w);
                }
            }
            
            Work w = pq.poll();
            answer += time - w.inputTime + w.workload;
            time += w.workload;
            list.remove(w);
        }
        
        return (int) answer / jobs.length;
    }
}