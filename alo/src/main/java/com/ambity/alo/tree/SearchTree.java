package com.ambity.alo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchTree {
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                list.add(stack.peek().val);
                root = stack.peek().right;
                stack.pop();
            }
        }
        return list;
    }

    // 先序遍历
    public static List<Integer> inpreorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                list.add(stack.peek().val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.peek().right;
                stack.pop();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.right = new TreeNode(6);

        List<Integer> list = inorderTraversal(p);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
    }
}
