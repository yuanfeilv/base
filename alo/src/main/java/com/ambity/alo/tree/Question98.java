package com.ambity.alo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 验证一颗树是否是二叉搜索树
 * 中序遍历，记录上次的值与当前值比较，如果上次的值比现在的小那么继续，否则返回false
  */

public class Question98 {
    public static boolean isValidBST(TreeNode root) {
        long preVal = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                if (stack.peek().val<=preVal){
                    return false;
                }else {
                    preVal = stack.peek().val;
                }
                root = stack.peek().right;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(-2147483648);
        System.out.println(isValidBST(p));
    }

}
