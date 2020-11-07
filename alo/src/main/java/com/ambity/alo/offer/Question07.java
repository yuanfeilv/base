package com.ambity.alo.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Question07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode getTree(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
        if (preLeft>preRight){
            return null;
        }
        TreeNode treeNode =new TreeNode(preorder[preLeft]);
        if (preRight==preLeft){
            return  treeNode;
        }
        //遍历inorder 数组，找到位置
        int mid = inLeft;
        for (int i = inLeft;i <= inRight;i++){
            if (inorder[i] == preorder[preLeft]){
                mid = i;
                break;
            }
        }
        treeNode.left = getTree(preorder,inorder,preLeft+1,preLeft+mid-inLeft,inLeft,mid-1);
        treeNode.right = getTree(preorder,inorder,preLeft+mid-inLeft+1,preRight,mid+1,inRight);
        return treeNode;
    }
}
