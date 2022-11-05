package Sort.structure;


/**
 *
 * @author yudi
 * @date 2022-10-18 20:53
 * 选择排序代码
 */
public class SelectSort extends Sort {


    public SelectSort(int size) {
        super(size);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (cmp(min, j) >= 0) {
                    min = j;
                }
            }
            swap(i, min);
        }
        printArray(array);
    }
}
