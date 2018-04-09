/**
 * Created by Qing (Chris) Yuan on Feb/11/2018 7:18 PM
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {10,10,10,-10,-10,-10,-10,-9,-9,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-8,-8,-8,-7,-7,-7,-7,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-3,-3,-2,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,2,3,3,3,4,4,4,5,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,9,9,9,9,9,10,10};
        int target = 6;
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        searchInRotatedSortedArrayII.search(nums, target);
    }

    public boolean search(int[] nums, int target) {
        if(nums == null | nums.length == 0) return false;

        //remove dup
        int right = 1, cur = nums[0];

        for(int i = 1; i < nums.length; i++) if(nums[i] != cur && nums[i] != nums[0])  cur = (nums[right++] = nums[i]);

        right--;
        int left = 0,  mid = (left + right)/2;
        while(left < right){
            mid = (left + right)/2;

            if(nums[mid] == target || nums[left] == target || nums[right] == target){
                return true;
            }else if((nums[mid] < target && nums[right] > target) || ((nums[mid] > nums[right]) && (nums[mid]  < target || nums[right] > target))){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(nums[mid] == target || nums[right] == target) return true; else return false;
    }
}
