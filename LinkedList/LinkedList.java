package LinkedList;

/**
 * @author yudi
 * @date 2020-06-15 22:48
 * 实现一个单链表
 */
public class LinkedList<E> extends AbstractList<E>  {


    /**
     * 链表首节点
     */
    private Node first;

    //代表链表元素的节点
    private static class Node<E> {

        public E element;

        public Node<E> next;

        public Node(E element,Node<E> next){
            this.element = element;
            this.next = next;
        }
    }


    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        Node<E> curr = node(index);
        E old = curr.element;
        curr.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        rangeCheckForAdd(index);
        if (index == 0){
            first = new Node(element,first);
        } else {
            Node<E> prev = node(index - 1);
            Node next =  prev.next;
            Node curr = new Node(element,next);
            prev.next = curr;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> curr = first;
        for (int i = 0; i < index ; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
