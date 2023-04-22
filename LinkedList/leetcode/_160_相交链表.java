package LinkedList.leetcode;

import LinkedList.List;
import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/16 11:49
 */
public class _160_相交链表 {


    /**
     * 最简便算法
     * 链表A和链表B的长度可能不同
     * 所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，
     * 让 p2 遍历完链表 B 之后开始遍历链表 A，
     * 这样相当于「逻辑上」两条链表接在了一起。
     * 如果说两个链表没有相交点，是否能够正确的返回 null 呢？ 判断p1和p2相等 到null
     */
    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            if ( p1 == null) p1 = headB;
            else p1=p1.next;
            if ( p2 == null) p2 = headA;
            else p2=p2.next;
        }
        return p1;
    }



    /**
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 1;
        ListNode p = headA;
        int lenB = 1;
        ListNode q = headB;

        while (p.next != null){
            lenA++;
            p = p.next;
        }


        while (q.next != null){
            lenB++;
            q = q.next;
        }

        //不相交
        if (p != q) return null;

        int m = Math.abs(lenA - lenB);

         p = headA;
         q = headB;


         //A链表的长度较长 让它先走m
        if (lenA > lenB) {
            for (int i = 0; i < m; i++) {
                p = p.next;
            }
            //B链表长度较长，让他先走m
        } else if (lenA < lenB){
            for (int i = 0; i < m; i++) {
                q = q.next;
            }
        }

        while(p != q){
             p = p.next;
             q = q.next;
        }
        return p ;

    }


}
