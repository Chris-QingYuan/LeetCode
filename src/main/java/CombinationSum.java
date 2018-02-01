import java.util.*;

/**
 * Created by Qing (Chris) Yuan on Feb/01/2018 1:09 AM
 */
public class CombinationSum {

    private List<List<Integer>> lol = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.findLastNotGreater(candidates,target,candidates.length - 1));
        combinationSum.combinationSum(candidates,target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0) return lol;
        Arrays.sort(candidates);
        if(target < candidates[0]) return lol;

        Deque<Integer> stack = new ArrayDeque<>();
        solve(candidates, target, stack, candidates.length - 1);

        return lol;
    }

    public void solve(int[] candidates, int target, Deque<Integer> stack, int rightLimit){
        int maxIndex = findLastNotGreater(candidates, target, rightLimit);
        if(maxIndex == -1) return;
        for(int i = maxIndex; i >= 0; i--){
            stack.push(candidates[i]);
            int diff = target - candidates[i];
            if(diff == 0){
                lol.add(new ArrayList<>(stack));
            }else{
                solve(candidates, diff, stack, i);
            }
            stack.pop();
        }
    }


    public int findLastNotGreater(int[] candidates, int target, int rightLimit){
        if(target < candidates[0]) return -1;
        int left = 0,
                right = rightLimit,
                mid;

        while(left < right){
            mid = (left + right) / 2;
            if(candidates[mid] == target) return mid;

            if(candidates[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return (candidates[left] <= target) ? left : left - 1;

    }
}
