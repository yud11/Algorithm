package Sort.leetcode;

import java.util.List;

/**
 * @autor yud1
 * @date 2022/10/26 13:04
 *
 * leetcode地址：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * 题目描述：
 *         在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 解题思路：
 *        使用归并排序的思想，在排序中比较两个数的大小
 */
public class ReversePairs_51 {

    public int reversePairs(int[] nums) {
        return process(nums,0,nums.length-1);
    }

    public int process(int[] nums, int l, int r){
       if (l >= r) return 0 ;
       int mid  = l + ((r-l)>>1);
       return process(nums,l,mid) + process(nums,mid+1,r)
               + merge(nums,l, mid,r);
    }

    public int merge(int[] nums, int l, int mid ,int r){
        int[] arr = new int[r-l+1];
        int i = 0;
        int res = 0;
        int p1 = l;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= r){
            if (nums[p1] > nums[p2]){
                res+= mid - p1 +1 ;
                arr[i++] = nums[p2++];
            }else {
                arr[i++] = nums[p1++];
            }
        }
        while (p1 <= mid){
            arr[i++] = nums[p1++];
        }

        while (p2 <= r){
            arr[i++] = nums[p2++];
        }

        for (i=0;i < arr.length;i++){
            nums[l+i] = arr[i];
        }
        return res;
    }
}
