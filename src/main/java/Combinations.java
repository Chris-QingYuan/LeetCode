import java.util.*;

/**
 * Created by Qing (Chris) Yuan on Feb/11/2018 9:24 AM
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 20, k = 8;
        long start = System.currentTimeMillis();
        Combinations combinations = new Combinations();
        combinations.combine(n, k);
        System.out.printf("cost %d ms", (System.currentTimeMillis() - start));
    }

    private List<List<Integer>> lol = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || n < k) return lol;

        Deque<Integer> deque = new ArrayDeque<>();
        helper(n, 0, k, deque);

        return lol;
    }

    private void helper(int n, int leftLimit, int remain, Deque<Integer> deque) {
        if (remain == 0) {
            lol.add(new ArrayList<>(deque));
            return;
        }
        for (int i = leftLimit; i <= n - remain; i++) {
            deque.push(i + 1);
            helper(n, i + 1, remain - 1, deque);
            deque.pop();
        }
    }
}
