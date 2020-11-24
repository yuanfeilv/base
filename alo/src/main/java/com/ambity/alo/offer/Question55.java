package com.ambity.alo.offer;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 */
public class Question55 {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.right==null && root.left==null){
            return 1;
        }
        return 1 + Math.max(depth(root.right),depth(root.left));
    }
}
