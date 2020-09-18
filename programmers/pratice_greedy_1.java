import java.util.*;
import java.util.stream.IntStream; 
class Solution {
    int[] r;
    int[] l;
    int answer = 0;
    public int solution(int n, int[] lost, int[] reserve) {
        r = reserve;
        l = lost;
        
        for (int i = 0; i < l.length; ++i) {
            checkArray(l[i], i);
        }
        for (int i = 0; i < l.length; ++i) {
            checkArray(l[i] - 1, i);
            checkArray(l[i] + 1, i);
        }        
        
        return n - lost.length + answer;
    }
    
    public void checkArray(int num, int index) {
        if (num > -1) {
            for (int i = 0; i < r.length; ++i) {
                if (r[i] == num) {
                    l[index] = -1;
                    r[i] = -1;
                    answer++;
                }
            }
        }
    }
}