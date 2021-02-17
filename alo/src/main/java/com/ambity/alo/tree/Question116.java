package com.ambity.alo.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL,
 * // 解法使用队列
 */
public class Question116 {
    public static Node connect(Node root) {
        if (root==null){
            return root;
        }
        int count = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (queue.size()>0){
            count++;
            Node node = queue.removeFirst();
            if (new Integer(count&(count+1))==0){
                // 此时到尾节点
                node.next = null;
            }else {
                node.next=queue.peek();
            }
            if (node.left!=null){
                queue.addLast(node.left);
            }
            if (node.right!=null){
                queue.addLast(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5,null,null,null);
        Node node4 = new Node(5,null,null,null);
        Node node6 = new Node(5,null,null,null);
        Node node7 = new Node(5,null,null,null);
        Node node2 = new Node(5,node4,node5,null);
        Node node3 = new Node(5,node6,node7,null);
        Node node1 = new Node(5,node2,node3,null);
        connect(node1);
    }
}
