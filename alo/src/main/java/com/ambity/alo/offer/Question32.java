package com.ambity.alo.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 */
public class Question32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[]{};
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
        arrayDeque.addLast(root);
        List<Integer> list = new ArrayList();
        while (!arrayDeque.isEmpty()){
            TreeNode treeNode = arrayDeque.removeFirst();
            list.add(treeNode.val);
            if (treeNode.left != null){
                arrayDeque.addLast(treeNode.left);
            }
            if (treeNode.right != null){
                arrayDeque.addLast(treeNode.right);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer integer : list){
            result[i] = integer;
            i++;
        }
        return result;
    }
}
