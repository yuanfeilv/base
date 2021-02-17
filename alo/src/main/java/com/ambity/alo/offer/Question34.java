package com.ambity.alo.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Question34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        path(result,list,sum,root);
        return result;
    }
    public void path(List<List<Integer>> result,List<Integer> list,int sum,TreeNode treeNode){
        if (treeNode.left == null && treeNode.right == null){
            if (treeNode.val == sum){
                list.add(sum);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
        }
//        if (treeNode.val>sum){
//            return;
//        }
        list.add(treeNode.val);
        if (treeNode.left !=null){
            path(result,list,sum-treeNode.val,treeNode.left);
        }
        if (treeNode.right !=null){
            path(result,list,sum-treeNode.val,treeNode.right);
        }
        // 移除当前元素
        list.remove(list.size()-1);
        return;
    }
}
