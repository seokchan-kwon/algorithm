import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int a = 0, b = 0, c = 0;
        int[] arr_a = {1,2,3,4,5};
        int[] arr_b = {2,1,2,3,2,4,2,5};
        int[] arr_c = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == arr_a[i%5]) {
                a++;
            }      
            if (answers[i] == arr_b[i%8]) {
                b++;
            }
            if (answers[i] == arr_c[i%10]) {
                c++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        if ((a >= b && b >= c) || (a >= c && c >= b)) {
            list.add(1);
            if (a == b) {
                list.add(2);
            }
            if (a == c) {
                list.add(3);
            }
        } else if ((b >= c && c >= a) || (b >= a && a >= c)) {
            list.add(2);
            if (a == b) {
                list.add(1);
            }
            if (b == c) {
                list.add(3);
            }
        } else if ((c >= a && a >= b) || (c >= b && b >= a)) {
            list.add(3);
            if (c == b) {
                list.add(2);
            }
            if (a == c) {
                list.add(1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray(); 
    }
}