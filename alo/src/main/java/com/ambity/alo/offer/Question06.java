package com.ambity.alo.offer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Question06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> integers = new Stack<>();
        while (head!=null){
            integers.push(head.val);
            head = head.next;
        }
        int[] result = new int[integers.size()];
        int i = 0;
        while (!integers.empty()){
            result[i] = integers.pop();
            i++;
        }
        return result;
    }
}
