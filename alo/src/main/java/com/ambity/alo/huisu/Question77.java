package com.ambity.alo.huisu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Question77 {
    public  List<List<Integer>> combine(int n, int k) {
        // 初始化记录数组
        List<List<Integer>> listAll = new ArrayList<>();
        if (k>n){
            return null;
        }
        Deque<Integer> now = new ArrayDeque<>();
        deep(n,k,listAll,now,1);
        return listAll;
    }
    public void deep(int n,int k,List<List<Integer>> listAll,Deque<Integer> now,int left){
        if (now.size()==k){
            listAll.add(new ArrayList<>(now));
            return;
        }
        for (int i=left;i<=n;i++){
            now.addLast(i);
            deep(n,k,listAll,now,i+1);
            now.removeLast();
        }
    }

}
