import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < k; ++i) {
            int num = sb.length() - 1;
            for (int j = 0; j < num; ++j) {
                if (sb.charAt(j) < sb.charAt(j + 1)) {
                    num = j;
                    break;
                }
            }
            sb.deleteCharAt(num);
        }
        return sb.toString();
    }
}