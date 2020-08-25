import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; ++i) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        
        if (map.size() == 1) {
            Map.Entry<String, Integer> entry = map.entrySet().iterator().next();
            return entry.getValue();
        }
        
        Collection<Integer> values = map.values();
         
        int answer = 1;
        for (Integer value : values) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}