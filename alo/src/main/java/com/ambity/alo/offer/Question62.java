package com.ambity.alo.offer;

import java.util.LinkedList;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 * 解法1 链表双指针，时间复杂度为m*n
 * 解法2 数组，数组中的值指向下一个 非 1 的数，每一次去除的都是 如果n+1>=m 也就是第m 个数，如果n+1<m 那么就是第m-n-1 个数
 */
public class Question62 {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public static void main(String[] args) {
        Question62 question62 = new Question62();
        System.out.println(question62.lastRemaining(5,3));
    }
}
