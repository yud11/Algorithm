package LinkedList.leetcode;

import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/16 11:21
 */
public class _141_环型链表 {


    /**
     * 快慢指针
     * 快指针每次走两步 慢指针每次走一步
     *  有环：快指针追上慢指针（无论环在哪，快慢指针都会进入到环中，所以快指针总会追上慢指针）
     *  无环：快指针走的快，所以只需要判断快指针next是否为空
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
