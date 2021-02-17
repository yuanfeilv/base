package com.ambity.alo.offer;

public class Question52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = null;
        if (headA == null || headB == null){
            return result;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(8);
        ListNode b = new ListNode(4);
        b.next = new ListNode(1);
        b.next.next = new ListNode(8);
        b.next.next.next = new ListNode(4);
        b.next.next.next.next = new ListNode(5);
        Question52 question52 = new Question52();
        System.out.println(question52.getIntersectionNode(a,b).val);
    }
}
