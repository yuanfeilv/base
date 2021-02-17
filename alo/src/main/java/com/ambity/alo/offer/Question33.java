package com.ambity.alo.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class Question33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0 || postorder.length == 1){
            return true;
        }
        return check(postorder,0,postorder.length-1);
    }
    public boolean check(int[] postorder, int i,int j){
        if(i >= j) {
            return true;
        }
        int p = i;
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && check(postorder, i, m - 1) && check(postorder, m, j - 1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,10,6,9,4,3};
        Question33 question33 = new Question33();
        System.out.println(question33.verifyPostorder(a));
    }
}
