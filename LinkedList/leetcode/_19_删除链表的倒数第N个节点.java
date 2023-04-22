package LinkedList.leetcode;

import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/22 10:46
 */
public class _19_删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //建立头结点方便
        ListNode tHead = new ListNode();
        tHead.next = head;
        ListNode p = tHead;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        ListNode q = tHead;

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        if (q.next == null) {
            q.next = null;
        } else {
            q.next = q.next.next;
        }

        return tHead.next;
    }
}
