package LinkedList.leetcode;

import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/23 14:09
 */
public class _206_反转链表 {



    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
