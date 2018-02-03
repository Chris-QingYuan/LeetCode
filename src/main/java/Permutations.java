import java.util.*;

/**
 * Created by Qing (Chris) Yuan on Feb/02/2018 11:32 PM
 */
public class Permutations {

    List<List<Integer>> lol = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2};
        Permutations permutations = new Permutations();
        permutations.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (nums == null || nums.length == 0) return lol;

        Deque<Integer> numsList = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }

        fillRestPos(stack, numsList);
        return lol;
    }

    private void fillRestPos(Deque<Integer> stack, Deque<Integer> numsList) {
        if (numsList.size() == 0) lol.add(new ArrayList<>(stack));
        else
            for (int i = 0; i < numsList.size(); i++) {
                stack.push(numsList.pollLast());
                fillRestPos(stack, numsList);
                numsList.push(stack.pop());
            }
    }
}
