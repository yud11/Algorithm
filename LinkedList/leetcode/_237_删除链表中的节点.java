package LinkedList.leetcode;

import LinkedList.structure.ListNode;

/**
 * @author yudi
 * @date 2020-06-16 22:59
 * <p>
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
