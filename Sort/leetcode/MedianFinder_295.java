package Sort.leetcode;

import java.util.PriorityQueue;

/**
 * @autor yud1
 * @date 2022/11/6 12:32
 * <p>
 * 平衡二叉堆的思想
 */
public class MedianFinder_295 {

    //大根堆
    private PriorityQueue<Integer> maxHeap = null;

    //默认小根堆，不用传参
    private PriorityQueue<Integer> minHeap = null;

    public MedianFinder_295() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }


    /**
     * @param num
     */
    public void addNum(int num) {
        //保证第一个元素加入到maxheap中
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        if (num >= maxHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        //保证两个堆是平衡的
        if (Math.abs(minHeap.size() - maxHeap.size()) >= 2) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) (maxHeap.poll() + minHeap.poll())) / 2;
        }
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }


    public static void main(String[] args) {
        MedianFinder_295 mt = new MedianFinder_295();
        mt.addNum(1);
        mt.addNum(2);
        mt.addNum(3);
        System.out.println(mt.findMedian());
    }

}
