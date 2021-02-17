package com.ambity.alo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root==null){
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if (treeNode.right!=null){
                stack.push(treeNode.right);
            }
            if (treeNode.left!=null){
                stack.push(treeNode.left);
            }
        }
        return list;
    }
}
