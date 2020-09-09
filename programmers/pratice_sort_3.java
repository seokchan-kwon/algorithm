import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int min = Arrays.stream(citations).min().getAsInt() > citations.length ? 0
                : Arrays.stream(citations).min().getAsInt();
        int max = Arrays.stream(citations).max().getAsInt();
        List<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; ++i) {
            int up = 0;
            int down = 0;
            for (int j = 0; j < citations.length; ++j) {
                if (i <= citations[j]) {
                    up++;
                } else {
                    down++;
                }
            }
            if (down <= i && i <= up) {
                list.add(i);
            }
        }

        return list.get(list.size() - 1);
    }
}