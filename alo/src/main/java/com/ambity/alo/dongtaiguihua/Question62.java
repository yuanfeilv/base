package com.ambity.alo.dongtaiguihua;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 题解，总共需要走m+n 步，m 步向右，n 步向做
 * 那么有 f(m,n) = f(m,n-1)+f(m-1,n),其中m=1或n=1 时只有一种，则动态规划写法
 */
public class Question62 {
    public static int uniquePaths(int m, int n) {
//        int[][] dp = new int[m+1][n+1];
//        for (int i =1;i<=n;i++){
//            dp[1][i] = 1;
//        }
//        for (int i =1;i<=m;i++){
//            dp[i][1] = 1;
//        }
//        for (int i = 2;i <= m;i++){
//            for (int j = 2;j <= n;j++){
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m][n];
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths(7,3));
    }
}
