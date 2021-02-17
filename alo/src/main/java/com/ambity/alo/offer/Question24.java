package com.ambity.alo.offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Question24 {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }

        ListNode result = head;
        ListNode pre = head.next;
        ListNode last = pre.next;
        result.next = null;
        while (last !=null){
            pre.next = result;
            result = pre;
            pre = last;
            last = last.next;
        }
        pre.next = result;
        return pre;
    }

    public static void main(String[] args) {
        Question24 question24 = new Question24();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        question24.reverseList(listNode);
    }
}
