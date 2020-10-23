package com.ambity.alo.lianbiao;

/**
 * 两两交换链表中的值,双指针，构建空的头节点
 * node0-> node1-> node2->node3->node4->null
 */
public class Request24 {
    public static ListNode swapPairs(ListNode head) {
        // 初始化两个指针，
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode result = swapPairs(listNode);
        while (result != null){
            System.out.println(result.val+"->");
            result = result.next;
        }
    }

}
