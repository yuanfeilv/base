package com.ambity.alo.lianbiao;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 分治算法，写出两个表的合并
 *
 *
 */
public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists,0,lists.length-1);
    }
    public ListNode mergeList(ListNode[] lists,int left,int right){
        if (left==right){
            return lists[left];
        }
        int mid = left + (left+right)/2;
        ListNode l1 =  mergeList(lists,left,mid);
        ListNode l2 =  mergeList(lists,mid+1,right);
        return mergeTwo(l1,l2);
    }
    public ListNode mergeTwo(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwo(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwo(list1,list2.next);
            return list2;
        }
    }
}
