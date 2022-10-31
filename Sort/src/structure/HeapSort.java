package structure;

/**
 * @autor yud1
 * @date 2022/10/29 15:14
 *
 * 堆排序:
 *      其本质是利用堆这个数据结构，堆是由一棵完全二叉树来完成，那么怎么来表示这棵完全二叉树呢？
 *      我们用数组来表示，数组从左到右可以看做是完全二叉树的层序遍历，即下标0的元素为根，下标为1的元素为0的左孩子，下标为2的元素为0的右孩子，依次类推
 *      下标为i的元素 其父亲节点的下标 为  (i-1)/2
 *                  其左孩子节点的下标为 2*i + 1
 *                  其右孩子的节点下标为 2*i + 2
 *
 *      大根堆结构的定义：对于每个节点都有 其值>= 其左右孩子的值，此时堆顶元素即为最大值。
 *
 *
 *      堆排序的过程：
 *          1)建堆：依次将数组元素，利用heapInsert操作，当插入一个新的节点时，需要判断它与父亲节点的大小是否满足大根堆的定义
 *                  ，若不满足，则交换父子节点的值，并且继续向上判断，直到父节点大于子节点的值 或来到根节点
 *          2）此时已经是一个大根堆，然后将堆顶元素和arr[--heapsize]进行交换，
 *              在堆顶进行下沉操作,使得其满足大根堆的特性，
 *          3）重复 2）的操作，当heapsize为0时，才是该数组已经有序
 *
 */
public class HeapSort  extends  Sort{


    protected HeapSort(int size) {
        super(size);
    }

    @Override
    public void sort() {
        if(array == null || array.length < 2){
            return;
        }
        for (int i = 0; i < array.length ; i++) {
            heapInsert(i);
        }
        int heapSize = array.length;

        while(heapSize > 0 ){
            swap(0, --heapSize);
            heapify(0,heapSize);
        }

        printArray(array);
    }

    /**
     * 在堆结构中插入一个新的元素
     * @param i 元素所在下标
     */
    public  void  heapInsert(int i){
        /**
         * while循环停止的条件
         *     1）array[i的父节点] >= array[i]的值
         *     2) 当i来到根节点时，该while条件也不满足了
         */
        while (array[i] > array[(i-1)/2]){
            swap(i,(i-1)/2);
            i = (i-1)/2;
        }
    }


    /**
     * 下沉，继续保持大根堆的特性
     * @param i
     * @param heapSize
     */
    public void heapify(int i, int heapSize){
        //i的左孩子
        int left = 2*i +1;
        while(left < heapSize){
            //找出左右孩子最大的元素下标
            int largest = left + 1 < heapSize && array[left] < array[left+1] ? left+1: left;
            //父节点 大于左右孩子的最大值，直接返回
            if (array[i] >= array[largest]){
                return;
            }
            /**
             * 否则将父节点和左右孩子较大的节点交换，对其子树继续循环判断，
             *  直到父节点大于左右孩子的最大值,或为叶节点 结束循环
             */
            swap(i,largest);
            i = largest;
            left = i * 2 + 1;
        }
    }
}
