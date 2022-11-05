package Sort.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor yud1
 * @date 2022/10/26 13:58
 */
public class CountSmaller_315 {


    public Map<Integer,Integer> maps = new HashMap<>();

    public List<Integer> countSmaller(int[] nums) {
        for (int num: nums) {
            maps.put(num,0);
        }
        process(nums,0,nums.length-1);
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            Integer count = maps.get(num);
            list.add(count);
        }
        return list;
    }

    public void process(int[] nums, int l, int r){
        if (l >= r) return ;
        int mid  = l + ((r-l)>>1);
        process(nums,l,mid);
        process(nums,mid+1,r);
        merge(nums,l, mid,r);
    }

    public void merge(int[] nums, int l, int mid ,int r){
        int[] arr = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= r){
            if (nums[p1] > nums[p2]){
                for (int j = p1; j <= mid; j++) {
                    Integer count = maps.get(j);
                    count++;
                    maps.put(p1,count);
                }
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
    }


    public void quickSort(int[] nums){

    }

    public void quicksort(int[] nums, int l ,int r){
        if (l >= r) return;
        int pivot = pivot(nums, l, r);
        quicksort(nums,l,pivot-1);
        quicksort(nums,pivot+1,r);
    }

    public int pivot(int[] nums, int l ,int r){
        int temp = nums[l];
        int start = l+1;
        int end = r;
        while(start <  end){
            while (start <= end && nums[start] <= temp){
                start++;
            }
            while(start <=  end && nums[end] >= temp){
                end--;
            }
            swap(nums,start,end);
        }
        swap(nums,l,start);
        return start;
    }

    public void swap(int[] nums ,int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }
}
