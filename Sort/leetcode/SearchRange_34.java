package Sort.leetcode;

/**
 * @autor yud1
 * @date 2022/11/5 08:26
 */
public class SearchRange_34 {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;


    public int[] searchRange(int[] nums, int target) {
        searchRange(nums,0,nums.length-1,target);
        return min == Integer.MAX_VALUE ? new int[]{-1,-1} : new int[]{min,max};
    }


    /**
     * @param nums
     * @param l
     * @param r
     * @param target
     */
    public void searchRange(int[] nums, int l, int r, int target) {
        if (l > r) return;
        if (l == r) {
            if (nums[l] == target) {
                min = Math.min(min, l);
                max = Math.max(max, l);
            }
        }
        int mid = l + ((r - l) >> 1);
        if (nums[mid] == target){
            min = Math.min(min, mid);
            max = Math.max(max, mid);
            searchRange(nums, l, mid-1,target);
            searchRange(nums,mid+1, r, target);
        } else if(nums[mid] > target){
            searchRange(nums, l, mid-1,target);
        }else{
            searchRange(nums,mid+1, r, target);
        }
    }
}
