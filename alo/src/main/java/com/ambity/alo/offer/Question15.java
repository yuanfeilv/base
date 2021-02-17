package com.ambity.alo.offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 *
 */
public class Question15 {
    public int hammingWeight(int n) {
        int i =0;
        while (n!=0){
            i += n & 1;
            n = n>>>1;
        }
        return i;
    }

    public static void main(String[] args) {
        Question15 question15 = new Question15();
        System.out.println(question15.hammingWeight(9));
    }
}
