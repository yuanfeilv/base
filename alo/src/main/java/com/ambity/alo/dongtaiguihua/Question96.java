package com.ambity.alo.dongtaiguihua;

import java.util.Arrays;

/**
 * 给定[0...n] 求可能的子树
 */
public class Question96 {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1]=1;
        for (int i =2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i]  = dp[i] + dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(10));
    }
}
