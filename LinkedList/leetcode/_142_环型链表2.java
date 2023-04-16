package LinkedList.leetcode;

import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/16 11:35
 */
public class _142_环型链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }

        /**
         *         w无环不能如下判断，当链表只有一个元素时  slow == fast
         *         if (slow != fast) return null;
         */

        if (fast.next == null || fast.next.next == null) return null;

        // 让slow 或fast 任意一个指针指向head节点
        slow = head;

        //同时走一步，相遇时即为第一个节点
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
