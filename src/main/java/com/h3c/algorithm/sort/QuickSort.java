package com.h3c.algorithm.sort;

/**
 * @author yudi
 * @date 2020-05-18 19:35
 *
 * 思想：
 *     在一个无序数组中，随机挑出一个元素作为轴点，找出这个轴点在数组中的位置，使得他左边数组的值比它小，右边数组的值比它大。
 *     那么再对左边和右边数组进行快速排序，一直这样递归下去，那么这个数组就是有序的。
 *     所以快速排序的本质：找到轴点在数组的位置，使得他左边数组的值比它小，右边数组的值比它大。
 *
 *     如何找到轴点在数组的位置？
 *      1）随机选取一个数组元素和数组索引为0的元素进行互换（这样是保证轴点的随机性，因为在某种极端情况下，会导致左右数组的大小极度不均匀，最差情况需要O（n^2）时间复杂度）
 *      2）备份这个轴点
 *      3）从后往前扫描数组每一个元素，并与为轴点的值进行比较，若轴点值较小，则end--，继续比较。若轴点值大于等于数组的元素，交换array[end]和array[begin]的值
 *      4）然后从前往后扫描数组每一个元素，并与为轴点的值进行比较，若轴点值较大，则begin++，继续比较。若轴点值大于等于数组的元素，交换array[end]和array[begin]的值
 *      5）重复以上操作，直到begin == end，这时，begin的索引就是轴点在数组的位置。
 *
 *      时间复杂度：
 *          在轴点左右元素比较均匀的情况下，同时也是最好的情况下
 *          记长度为n的数组的时间复杂度为T（n），则有：
 *  *              T（n） = 2 * T（n/2） + O（n）;
 *                 则最好情况下的是O（nlogn）
 *          在轴点左右元素极度不均匀的情况下，同时也是最坏的情况下
 *                 T（n） =  T（n-1） + O（n）;
 *                 则最坏情况下是O（n^2）
 *          平均情况下是O（nlogn）
 *      空间复杂度：递归调用logn次，则空间复杂度为 O（logn）
 *
 *      属于不稳定排序
 */
public class QuickSort extends Sort{

    public QuickSort(int size){
        super(size);
    }

    public void sort(){
        sort(0,array.length);
        printArray(array);
    }

    private  void sort(int begin, int end) {
        /**
         * 元素数量==1，不需要排序，直接return
         */
        if ((end - begin) < 2) {
            return;
        }
        //计算出轴点在数组的位置，并使得他左边数组的值比它小，右边数组的值比它大
        int mid = pivotIndex(begin, end);
        //将左边数组进行快速排序
        sort(begin, mid);
        //将右边数组进行快速排序
        sort(mid + 1, end);
    }


    /**
     *
     * @param begin
     * @param end
     * @return
     */
    private int pivotIndex(int begin, int end) {
        //随机选出轴点元素放在index为begin的位置
        swap(begin,begin + (int)(Math.random() *(end-begin)));
        //备份轴点元素
        int pivot = array[begin];
        //对[begin，end)进行排序，end要指向数组最后一个元素
        end--;
        //所有操作均需满足 begin < end
        while (begin < end) {
            while (begin < end) {
                //轴点 < array[end],只需要移动指针就可， 轴点==array[end],为什么需要进行元素互换？ 是为了全部元素一样的情况下，会导致左右数组大小极度不均衡，
                // 从而导致需要O（n^2）时间复杂度
                if (pivot < array[end]) {
                    end--;
                } else {
                    //交换元素到begin位置，并且begin++;
                    array[begin++] = array[end];
                    //break保证了，只要交换完元素，就改变数组扫描方向
                    break;
                }
            }

            //操作如上，只不过上面是从后往前扫描，本次是往从前往后扫。
            while (begin < end){
                if(pivot > array[begin]) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        //将轴点赋值给 计算出来的 pivotindex
        array[begin] = pivot;
        return begin;
    }
}
