import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        for (char c : name.toCharArray()) {
            int gap = c - 'A';
            if (gap > 13) {
                answer += 26 - gap;
            } else {
                answer += gap;
            }
        }
        
        if (!name.contains("A")) {
            return answer + name.length() - 1;
        }
        
        List<Integer> front = new ArrayList<>();
        List<Integer> back = new ArrayList<>();
        for (int i = 0; i < (name.length() / 2) + 1; ++i) {
            if (name.charAt(i) != 'A') {
                front.add(i);
            }
            if (name.charAt(name.length() - 1 - i) != 'A') {
            	back.add(name.length() - 1 - i);
            }
        }
        if (name.length() % 2 == 1 && name.charAt(name.length() / 2) != 'A') {
        	back.add(name.length() / 2);
        }
        
        int frontSize = front.size();
        int backSize = back.size();
        if (frontSize == 0 && backSize == 0) {
        	return 0;
        }
        if (frontSize == 0) {
        	return answer + name.length() - back.get(backSize - 1);
        }
        if (backSize == 0) {
        	return answer + front.get(frontSize - 1);
        }
        
        int min = Math.min(Math.min(back.get(0), 
                                    name.length() - front.get(0)), 
                           Math.min((name.length() - back.get(backSize - 1)) * 2 + front.get(frontSize - 1), 
                                    front.get(frontSize - 1) * 2 + name.length() - back.get(backSize - 1)));
        return answer + min;
    }
}