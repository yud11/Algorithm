package LinkedList.leetcode;

import LinkedList.List;
import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/22 11:34
 */
public class _876_链表的中间节点 {

    public ListNode middleNode(ListNode head) {
        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode q = dummy;
        while(q.next != null && q.next.next!=null){
            p = p.next;
            q = q.next.next;
        }
        return  p.next;
    }
}
