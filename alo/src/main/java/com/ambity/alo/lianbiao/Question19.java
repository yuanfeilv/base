package com.ambity.alo.lianbiao;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Question19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode sec = head;
        int i=1;
        while (first.next!=null){
            if (i>n){
                sec = sec.next;
            }
            first = first.next;
            i++;
        }
        if (i==n){
            head = head.next;
        } else if (i>n) {
            sec.next = sec.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        removeNthFromEnd(listNode,1);
    }
}
