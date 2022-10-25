package structure;

/**
 * @author yudi
 * @date 2020-05-18 19:52
 */
public abstract class Sort {

    protected   int[] array;
    protected  Sort(int size) {
        array = new int[size];
        for (int i = 0; i<size;i++) {
            array[i] = (int)(Math.random() * size);
        }
    }
    public abstract void sort();

    protected void printArray(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] +",");
        }
        sb.append("]");
        System.out.println(sb);
    }

    protected void swap(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected int cmp(int i,int j){
       if(array[i] < array[j]){
           return -1;
       } else if(array[i] > array[j]) {
           return 1;
       }else {
           return 0;
       }
    }
}
