package com.ambity.alo.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class Question22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null){
            return head;
        }
        int count = 1;
        ListNode result = null;
        ListNode first = head;
        boolean flag = false;
         while (first.next != null){
             if (flag){
                 result = result.next;
             }else {
                 if (count < k-1){
                     count ++;
                 }else {
                     flag = true;
                     result = head;
                 }
             }
             first = first.next;
         }
         if (k == 1){
             return first;
         }
         return result;
    }
}
