import java.util.*;

/**
 * Created by Qing (Chris) Yuan on Feb/11/2018 9:47 AM
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {8,4,5,6,2,3,7,13,42};
        long start = System.currentTimeMillis();
        Subsets subsets = new Subsets();
        subsets.subsets(nums);
        System.out.printf("cost %d ms", (System.currentTimeMillis() - start));
    }

    private List<List<Integer>> lol = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        lol.add(new ArrayList<>(0));
        if(nums == null || nums.length == 0) return lol;

        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        helper(nums, n, 0, deque);

        return lol;
    }

    private void helper(int[] nums, int n, int leftLimit, Deque<Integer> deque) {
        for (int i = leftLimit; i < n; i++) {
            deque.push(nums[i]);
            lol.add(new ArrayList<>(deque));
            helper(nums, n, i + 1, deque);
            deque.pop();
        }
    }
}
