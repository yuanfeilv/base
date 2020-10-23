package com.ambity.alo.dongtaiguihua;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *  f(m.n) = list-m(n)+ min(f(m-1,n-1),f(m-1,n))
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *  
 *
 */
public class Question120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0){
            return 0;
        }
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i =1;i<triangle.get(triangle.size()-1).size();i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i=1;i<triangle.size();i++){
            List<Integer> list = triangle.get(i);
            for (int j=list.size()-1;j>-1;j--){
                if (j==0){
                    dp[j] = list.get(j)+dp[j];
                }else if (j==triangle.get(i).size()){
                    dp[j] = dp[j-1]+list.get(j);
                }else {
                    dp[j] = Math.min(dp[j-1],dp[j])+list.get(j);
                }
            }
        }
        Integer integer = Integer.MAX_VALUE;
        for (int i =0;i<triangle.get(triangle.size()-1).size();i++){
            integer = Math.min(integer,dp[i]);
        }
        return integer;
    }

    public static void main(String[] args) {
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(2);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        List<Integer> integers3 = new ArrayList<>();
        integers3.add(6);
        integers3.add(5);
        integers3.add(7);
        List<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        integers4.add(1);
        integers4.add(8);
        integers4.add(3);
        Question120 question120 = new Question120();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(integers1);
//        lists.add(integers2);
//        lists.add(integers3);
//        lists.add(integers4);
        question120.minimumTotal(lists);
        System.out.println(question120.minimumTotal(lists));
    }
}
