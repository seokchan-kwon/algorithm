import java.util.*;
class Solution {

    public HashSet<Integer> hs = new HashSet<>();

    public int solution(String numbers) {
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(Character.toString(c));
        }

        for (int i = 1; i <= numbers.length(); ++i) {
            permutation(list, result, numbers.length(), i);
        }

        if (hs.size() == 0) {
            return 0;
        }

        int count = 0;
        Iterator<Integer> itr = hs.iterator();
        while (itr.hasNext()) {
            if (isPrimeNumber(itr.next())) {
                count++;
            }
        }

        return count;
    }

    public boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }

        if (num == 2 || num == 3) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num) + 1; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void permutation(List<String> list, List<String> result, int n, int r) {
        if (r == 0) {
            String s = "";
            for (int i = 0; i < result.size(); ++i) {
                s += result.get(i);
            }
            hs.add(Integer.parseInt(s));
            return;
        }

        for (int i = 0; i < n; ++i) {
            result.add(list.remove(i));
            permutation(list, result, list.size(), r - 1);
            list.add(i, result.remove(result.size() - 1));
        }
    }
}