package Greed.leetcode;

import java.util.PriorityQueue;

/**
 * @autor yud1
 * @date 2022/11/6 11:57
 */
public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //项目代价的小根堆
        PriorityQueue<Node> minCaptital = new PriorityQueue<>((n1, n2) -> n2.capital - n1.capital);
        //利润最大化的大根堆
        PriorityQueue<Node> maxProfit = new PriorityQueue<>((n1, n2) -> n1.profit - n2.profit);

        /**
         * 将所有项目加入到小根堆中
         */
        for (int i = 0; i < capital.length; i++) {
            minCaptital.add(new Node(profits[i], capital[i]));
        }

        int sum = w;
        //最多k个项目
        for (int i = 0; i < k; i++) {
            //将代价小于w的项目全部从小根堆弹出 加入到大根堆
            while(!minCaptital.isEmpty() && minCaptital.peek().capital <= sum){
                maxProfit.add(minCaptital.poll());
            }

            if(maxProfit.isEmpty()){
                return sum;
            }

            sum += maxProfit.poll().profit;
        }

        return sum;
    }
}


class Node {
    //利润
    int profit;

    //代价
    int capital;

    public Node(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

