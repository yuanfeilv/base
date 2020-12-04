package com.ambity.alo.lianbiao;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        return addList(l1,l2,0);
    }
    public ListNode addList(ListNode l1, ListNode l2,int value){
        if (l1==null && l2==null ){
            if (value==1){
                return new ListNode(1);
            }else {
                return null;
            }
        }
        if (l1!=null && l2 !=null){
            int b = l1.val + l2.val + value;
            ListNode node = new ListNode(b%10);
            node.next = addList(l1.next,l2.next,b/10);
            return node;
        }
        ListNode temp = null;
        if (l1 == null){
            temp = l2;
        }else {
            temp = l1;
        }
        int b = temp.val + value;
        ListNode node = new ListNode(b%10);
        node.next = addList(temp.next,null,b/10);
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        Question2 question2 = new Question2();
        ListNode listNode = question2.addTwoNumbers(l1,l2);
        System.out.println(listNode.val);
    }
}
