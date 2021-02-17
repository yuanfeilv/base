package com.ambity.alo.dongtaiguihua;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * x 轴acount ,y 轴 amount 数量
 */
public class Question518 {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i=0;i<=coins.length;i++){
            dp[i][0] = 1;
        }
        for (int i=1;i<coins.length+1;i++){
            for (int j=1;j<amount+1;j++){
                if (coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(5,coins));
    }
}
