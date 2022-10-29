package structure;

/**
 * @autor yud1
 * @date 2022/10/29 10:45
 *
 * 快排3.0
 *
 */
public class QuickSort3  extends Sort{
    protected QuickSort3(int size) {
        super(size);
    }

    @Override
    public void sort() {
        if(array == null || array.length < 2){
            return;
        }
        quickSort3(0,array.length-1);
        printArray(array);
    }

    public void quickSort3( int l ,int r){
        if (l < r){
            //随机选择一个数作为pivot，并和最后一个数进行交换
            swap(l + (int)Math.random()*(r-l+1),r);
            //返回pivot的左右边界
            int[] pivot = partition(l,r);
            //递归左边
            quickSort3(l,pivot[0]-1);
            //递归右边
            quickSort3(pivot[1]+1,r);
        }
    }

    /**
     *  将数组分为三部分 [<pivot, ==pivot, >privot]
     * @param l 左边界
     * @param r 右边界
     * @return 返回==pivot的左右边界
     *
     * less：表示小于pivot的元素下标
     * more：表示大于pivot的元素下标
     *
     * 从左向右遍历数组：将数组分为三部分 [<pivot, ==pivot, >privot]
     * 判断条件：
     *        arr[i] < pivot : 交换less+1下标对应的元素和下标i对应的元素，并且,less++,i++
     *        arr[i] = pivot : i++
     *        arr[i] > pivot : 交换more+1下标对应的元素和下标i对应的元素，并且，more--，i不变，因为还需比较此时arr[i]和pivot的大小
     *
     * 举例说明：
     *        1,less = -1; more = 6, i = 0 ,arr = [3,5,6,2,8,9,5]
     *        2,less = 0, more = 6, i =1, arr = [3,5,6,2,8,9,5]
     *        3,less = 0, more = 6, i =2, arr = [3,5,6,2,8,9,5]
     *        4,less = 0, more = 5, i =2, arr = [3,5,9,2,8,6,5]
     *        5,less = 0, more = 4, i =2, arr = [3,5,8,2,9,6,5]
     *        6,less = 0, more = 3, i =2, arr = [3,5,2,8,9,6,5]
     *        7,less = 1, more = 3, i =3, arr = [3,2,5,8,9,6,5]
     *        8,while判断失败，swap(more,r); arr = [3,2,5,5,9,6,8]
     */
    public int[] partition(int l, int r){
        int num = array[r];
        int less = l-1;
        int more = r;
        int i = l;
        while(i < more){
            if (array[i] < num){
                swap(++less,i++);
            } else if (array[i] == num){
                i++;
            }else{
                swap(--more,i);
            }
            printArray(array);
        }
        swap(more,r);
        return new int[]{less+1, more};
    }
}
