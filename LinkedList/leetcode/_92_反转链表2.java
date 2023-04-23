package LinkedList.leetcode;

import LinkedList.structure.ListNode;

/**
 * @autor yud1
 * @date 2023/4/23 14:11
 */
public class _92_反转链表2 {


    /**
     *
     * https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-8f30d/di-gui-mo--10b77/
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }


    public ListNode successor = null;

    public ListNode reverseN(ListNode head , int n){
        if (n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
