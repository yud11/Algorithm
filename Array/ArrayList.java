package Array;

/**
 * @author yudi
 * @date 2020-02-06 21:40
 * Description 使用数组实现容量大小无限的动态数组
 */
public class ArrayList<E> {


    /**
     * 保存所有的元素的数组
     */
    E[] array;

    /**
     * 记录ArrayList的长度
     */
    private int size = 0;

    /**
     * 默认初始化长度
     */
    private static final int DEFAULT_SIZE = 16;


    public ArrayList() {
        array = (E[]) new Object[DEFAULT_SIZE];
    }

    public ArrayList(int capacity) {
        capacity = capacity > DEFAULT_SIZE ? capacity : DEFAULT_SIZE;
        array = (E[]) new Object[capacity];
    }

    /**
     * 返回集合中元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return 0 == size;
    }

    /**
     * 添加元素
     *
     * @param element 元素
     */
    public void add(E element) {
        add(size,element);
    }

    public E get(int index) {
        if(index <0 || index > size-1){
            throw new IndexOutOfBoundsException("下标越界，集合长度为："+size+ "下标为"+index);
        }
        return array[index];
    }

    public E set(int index, E element) {
        if(index <0 || index > size-1){
            throw new IndexOutOfBoundsException("下标越界，集合长度为："+size+ "下标为"+index);
        }
        E old = array[index];
        array[index] = element;
        return old;
    }

    /**
     * 制定索引添加元素
     * @param index 索引
     * @param element 元素
     */
    public void add(int index, E element) {
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("下标越界，集合长度为："+size+ "下标为"+index);
        }

        ensureCapacity(size +1);

        for (int i = size-1; i >= index ; i--) {
            array[i+1] = array[i];
        }
        size++;
        array[index] = element;
    }

    /**
     * 删除集合中某个元素
     * @param index 下标
     * @return 删除的元素
     */
    public E remove(int index) {
        E e = get(index);
        for (int i = index+1; i < size; i++) {
            array[i-1] = array[i];
        }
        array[--size] = null;
        return e;
    }

    /**
     * 寻找元素所在的索引
     *
     * @param element 元素
     * @return 索引
     */
    public int indexOf(E element) {
        if (null == element) {
            for (int i = 0; i < size; i++) {
                if (element == null) {
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;

    }


    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * 扩容
     *
     * @param capacity 现在的容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = array.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity << 1;
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean contains(E element){
        return indexOf(element) >=0;
    }





}
