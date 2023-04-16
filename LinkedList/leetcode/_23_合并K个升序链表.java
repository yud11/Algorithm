package LinkedList.leetcode;

import LinkedList.List;
import LinkedList.structure.ListNode;

import java.util.PriorityQueue;

/**
 * @autor yud1
 * @date 2022/11/20 19:43
 */
public class _23_合并K个升序链表 {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode();
        ListNode p = head;
        PriorityQueue<ListNode> pq =  new PriorityQueue<>((a,b) -> (a.val- b.val));

        for(ListNode head1: lists){
            if (head1!=null){
                pq.add(head1);
            }
        }

        while(!pq.isEmpty()){
            ListNode q = pq.poll();
            p.next = q;
            if (q.next != null){
                ListNode temp = q.next;
                q.next = null;
                pq.add(temp);
            }
            p = q;
        }

        return head.next;

    }
}
