public class Test {
    public void combination(List<Integer> arr, List<Integer> result, int index, int n, int r) {
        if (r == 0) {
            // answer.add(result.toString());
            return;
        }

        for (int i = index; i < n; ++i) {
            result.add(arr.get(i));
            combination(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }

    public void permutation(List<Integer> arr, List<Integer> result, int n, int r) {
        if (r == 0) {
            // answer.add(result.toString());
            return;
        }

        for (int i = 0; i < n; ++i) {
            result.add(arr.remove(i));
            permutation(arr, result, arr.size(), r - 1);
            arr.add(result.get(result.size() - 1));
        }
    }

    public void powerSet(List<Integer> arr, boolean[] state, int i, int end) {
        if (i >= end) {
            for (int j = 0; j < end; ++j) {
                if (state[j]) {
                    // temp += arr.get(j) + " ";
                }
            }
            // answer.add(temp);
            return;
        }

        state[i] = false;
        powerSet(arr, state, i + 1, end);
        state[i] = true;
        powerSet(arr, state, i + 1, end);
    }
}
