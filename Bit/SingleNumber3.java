package Bit;

/**
 * @autor yud1
 * @date 2022/10/24 19:40
 *
 * leetcode地址：https://leetcode.cn/problems/single-number-iii/submissions/
 *
 *
 * 题目描述：
 *        给你一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按任意顺序返回答案。
 *        你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * 解题思路：
 *        只有两个元素a,b出现一次，那么全部异或一遍的结果是c = a^b,由于a!=b,所以c不为0，找到c的二进制最右边一位为1的一位
 *        由异或运算的规则可知，a，b两个元素在这个位上面不一样，一个为0，一个为1，数组中此位为0的元素全部异或，则得出a或b
 * 解题步骤：
 *        1，数组所有元素异或一遍，得到c
 *        2，找到最右的一位
 *        3，找到所有此位为0的元素全部异或 得到a or b
 *        4，c ^a
 *
 *
 *

 */
public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int ans1 =  0;
        for(int i : nums){
            ans1 = ans1 ^ i;
        }
        //找到最右边的那个1
        int temp = ans1 & (~ans1 +1);
        int ans2 = 0;
        for(int i: nums){
            if ((i & temp) == 0){
                ans2 = ans2 ^ i;
            }
        }
        int[] arr = new int[2];
        arr[0] =  ans2;
        arr[1] =  ans1 ^ ans2;
        return arr;
    }
}
