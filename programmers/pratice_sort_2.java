import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i=0; i<arr.length; i++) 
            arr[i] = numbers[i] + "";

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        for (int i=0; i<arr.length; i++)
            answer += arr[i];

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}