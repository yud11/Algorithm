package structure;

/**
 * @author yudi
 * @date 2020-05-16 14:30
 *
 * 思想：一个有序的数组 = 两个长度为原数组一半的有序数组合并而来
 *      所以对一个数组排序 可以分解为 对两个子数组排序，并合并。这样一直递归下去，当数组长度为1时，这时不用排序了，只需将两个长度为1的子数组和并，就可以了
 *      所以归并排序的本质是 将子数组不断的合并，合并要保证合并完的数组是有序的。
 *
 *      时间复杂度：
 *          由于归并排序是递归调用，所以它的时间复杂度不能一眼就看出啦，我们需要使用递推公式来计算。
 *          我们知道归并排序其实是两个子数组的排序+合并，合并数组其实是将遍历数组的每个元素进行比较，所以合并的时间复杂度为O(n)
 *          记长度为n的数组的时间复杂度为T（n），则有：
 *              T（n） = 2 * T（n/2） + O（n）;
 *             ->   T（n）/n = T（n/2）/(n/2) + O（1）;
 *             记S（n） = T（n）/n;
 *             -> S(n) = S(n/2) + O（1）;
 *             -> S(n) = S(n/4) + O（2）;
 *             -> S(n) = S(n/8) + O（3）;
 *             -> S(n) = S(n/2^k) + O（k）;
 *             -> S(n) = S(1) + O（logn）;
 *             -> S(n) = 1 + O（logn）;
 *             -> T（n） = n + nO（logn）
 *          所以归并排序的时间复杂度为O（nlogn）
 *
 *
 *     空间复杂度：
 *           O（n/2 + logn）
 *           n/2 : leftarray
 *           logn: 递归调用的次数，每次调用递归，需要消耗JVM栈空间
 *          所以归并排序的空间复杂度为O(n)
 *
 *
 */
public class MergeSort extends Sort {

    /**
     * 初始原数组的左边数组
     */
    private  int[] leftArray;

    public MergeSort(int size) {
        super(size);
        leftArray = new int[array.length >> 1];
    }

    /**
     * 排序[begin,end）里面的元素
     * @param begin
     * @param end
     */
    public  void sort(int begin, int end){
        //子数组只有一个元素时返回
        if((end -begin) < 2) {
            return;
        }
        int mid = (begin + end) >>1;
        //将左边数组进行排序
        sort(begin,mid);
        //将右边数组进行排序
        sort(mid,end);
        //将两个子数组合并成一个有序数组
        merge(begin,mid,end);
    }

    /**
     * 将[begin ,mid) 和 [mid,end)两个数组进行合并
     * 需要额外的数组空间，来进行比较
     * 将左边数组的值，即[begin ,mid)的值复制到另外的数组中（leftArray），这时就可以用leftArray和右边数组的值[mid,end)进行比较，
     * 将较小的值从左边的数组的begin索引开始，依次赋值。而不用担心覆盖原来数组的值，
     * 比较完，会有如下两种情况：
     *                    1） leftarray 数组的值赋值完了，这时右边数组剩下来的值不需要任何操作，因为他本来就在数组的位置
     *                    2） 右边数组赋值完了，需要将leftarray剩下的值，赋值到原数组的右边。
     *
     * @param begin
     * @param mid
     * @param end
     */
    public  void merge(int begin, int mid, int end){

        /**
         * li:当前需要比较元素leftarray的索引
         * le:leftarray的阈值
         */
        int li = 0,le = mid - begin;
        /**
         * ai:比较完较小的元素的 需要插入到原数组索引位置
         */
        int ai = begin;
        /**
         * ri: 当前需要比较元素array的索引
         * le: array索引的阈值
         */
        int ri = mid,re = end;
        /**
         * 将原数组的左边数组的值 copy到新的数组中
         */
        for (int i = 0; i < le; i++) {
            leftArray[i] = array[begin+i];
        }

        /**
         * 当li>=le时，说明左边数组已经全部比较完毕。
         * 上面已经说明比较完，会有如下两种情况：
         *                    1） leftarray 数组的值赋值完了，这时右边数组剩下来的值不需要任何操作，因为他本来就在数组的位置
         *                    2） 右边数组赋值完了，需要将leftarray剩下的值，赋值到原数组的右边。
         *                    第一种情况，当左边数组已经全部比较完毕，则合并结束了
         *                    第二种情况，右边数组赋值完毕之后，还需要将leftarray剩下的值，赋值到原数组的右边，所以，也是等到左边数组赋值完毕，则合并结束
         *                    综上：则左边数组赋值结束，合并结束，可推出循环。
         */
        while(li < le) {
            /**
             * ri < re 时 则需要比较左边数组和右边数组的值，较小的值赋给array[ai]
             * ri >= re 时，说明右边数组已经比较完成，只需将左边数组的值，依次赋值为array[ai]
              */
          if(ri < re && array[ri] < leftArray[li]){
              array[ai++] = array[ri++];
          } else {
              array[ai++] = leftArray[li++];
          }
        }
    }

    public void sort() {
        sort(0,array.length);
        printArray(array);
    }
}
