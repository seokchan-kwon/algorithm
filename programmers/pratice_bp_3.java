import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int nm = brown + yellow;
        for (int i = 3; i <= Math.sqrt(nm); ++i) {
            if (nm % i == 0) {
                if ((2*i + 2*(nm / i)) == brown + 4) {
                    answer[0] = i;
                    answer[1] = nm / i;
                } 
            }
        }
        
        Arrays.sort(answer);
        int temp = answer[0];
        answer[0] = answer[1];
        answer[1] = temp;
        
        return answer;
    }
}