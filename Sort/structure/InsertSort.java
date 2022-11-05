package Sort.structure;

/**
 * @autor yud1
 * @date 2022/10/25 15:33
 *
 * 简单插入排序
 */
public class InsertSort  extends Sort{

    protected InsertSort(int size) {
        super(size);
    }

    @Override
    public void sort() {
        for(int i = 1; i < array.length; i++){
            for (int j = i; j >0 && array[j] < array[j-1]; j--) {
                swap(j,j-1);
            }
        }
        printArray(array);
    }
}
