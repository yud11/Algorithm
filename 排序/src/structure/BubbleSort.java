package structure;

/**
 * @autor yud1
 * @date 2022/10/18 20:54
 */
public class BubbleSort extends Sort{
    protected BubbleSort(int size) {
        super(size);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (cmp(j,j+1) > 0){
                    swap(j,j+1);
                }
            }
        }
        printArray(array);
    }
}
