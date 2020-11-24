package com.ambity.alo.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * // 中序遍历到k
 */
public class Question54 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        if(k == 0) {
            return;
        }
        if(--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

}
