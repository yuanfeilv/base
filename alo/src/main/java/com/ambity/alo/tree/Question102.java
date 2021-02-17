package com.ambity.alo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int j=1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.removeFirst();
            level.add(treeNode.val);
            if (treeNode.left!=null){
                queue.addLast(treeNode.left);
            }
            if (treeNode.right!=null){
                queue.addLast(treeNode.right);
            }
            j--;
            if (j==0){
                result.add(level);
                level = new ArrayList<>();
                j=queue.size();
            }
        }
        return result;
    }
}
