package Bit;

/**
 * @autor yud1
 * @date 2022/10/25 12:51
 *
 * leetcode地址：https://leetcode.cn/problems/single-number-ii/
 *
 * 题目描述：
 *        给你一个整数数nums ，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。
 *        你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 * 解题思路：
 *        对于出现三次的元素，那么其32位的二进制的每一位无论是0或者是1都出现3次，出现一次的元素a，其每一位只出现一次，
 *        则统计每一位上面的总和，若是三的倍数，则a的该位为0，若余数为1，则a的该位为0
 * 解题步骤：
 *        1，循环遍历32位，计算每个二进制位上面数组所有元素的总和
 *        2，判断是否有余数，有，则该位为1，无，该位为0，不做处理 继续循环
 *
 *
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
