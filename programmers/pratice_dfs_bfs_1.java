import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int stage) {
        if (stage == numbers.length) {
            if (target == Arrays.stream(numbers).sum()) {
                answer++;
            }
        } else {
            numbers[stage] *= 1;
            dfs(numbers, target, stage + 1);
            numbers[stage] *= -1;
            dfs(numbers, target, stage + 1);
        }
    }
}