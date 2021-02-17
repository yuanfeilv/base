package com.ambity.alo.offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class Question25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val> l2.val){
            ListNode listNode = l2.next;
            l2.next = merge(l1,listNode);
            return l2;
        }else {
            ListNode listNode = l1.next;
            l1.next = merge(listNode,l2);
            return l1;
        }
    }
}
