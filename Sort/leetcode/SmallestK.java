package Sort.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @autor yud1
 * @date 2022/10/31 11:29
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] =  queue.poll();
        }
        return ans;

        Arrays.sort();
    }
}
