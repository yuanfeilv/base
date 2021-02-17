package com.ambity.alo.dongtaiguihua;

/**
 * 输出所有可能的树
 */
public class Question95 {
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
}

