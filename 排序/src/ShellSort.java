import java.util.ArrayList;
import java.util.List;

/**
 * @author yudi
 * @date 2020-05-19 7:58
 *
 *  思想：
 *      本质上是插入算法的改进，给定一个步长序列，对数组相隔步长的元素进行插入排序。
 *      插入排序的算法跟数组的初始顺序有大很大关系，当数组中的逆序对数量很多时，会导致元素需要移动多次，才能到正确的位置，时间复杂度最差时为O（n^2）
 *      而shell排序改进了插入算法，先对步长序列中的每个步长，进行排序，这样使得元素可以一次移动很远位置，保证了时间复杂度。
 *
 *      时间复杂度 ：
 *          最好情况：O(n)
 *          最坏情况：O(n^4/3) ~O(n^2)
 *          平均情况：根据步长序列
 */
public class ShellSort extends Sort{

    public ShellSort(int size) {
        super(size);
    }
    public void sort() {
        //取出步长序列
        List<Integer> stepSequence = getStepSequence();
        //对每个步长进行插入排序
        for (Integer step : stepSequence) {
            //插入排序
            for (int i = 0; i < step; i++) {
                for(int j = i + step;j<array.length;j+=step) {
                    int cur = j;
                    while(cur >i && cmp(cur,cur-step) < 0){
                        swap(cur,cur-step);
                        cur -= step;
                    }
                }
            }
        }
        printArray(array);
    }

    /**
     * shell本地给出的步长序列（1,2,4,8……）
     * @return
     */
    private List<Integer> getStepSequence(){
        List<Integer> steps = new ArrayList<Integer>();
        int step = array.length;
        while((step >>= 1) > 0 ){
            steps.add(step);
        }
        return steps;
    }
}
