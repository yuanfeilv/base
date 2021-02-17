package com.ambity.alo.offer;

import java.math.BigDecimal;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * 动态规划
 * dp(i,j表示dp i+1 次 j+1出现的此时)
 */
public class Question60 {
    public double[] dicesProbability(int n) {
        if (n == 0) {
            return new double[]{};
        }
        int[] dp = new int[6*n];
        for (int i = 0;i<6;i++){
            dp[i] = 1;
        }
        for (int i = 1;i < n;i ++){
            for (int j = 6*(i+1)-1 ;j>=0;j--){
                dp[j] = 0;
                for (int k =1;k<7;k++){
                    if (j-k>=0){
                        dp[j] += dp[j-k];
                    }
                }
            }
        }
        double[] result = new double[5*n+1];

        double all = Math.pow(6,n);
        for (int i=0;i<5*n+1;i++){
            result[i] = (dp[i+n-1] * 1.0)/all;
        }
        return result;
    }

    public static void main(String[] args) {
        Question60 question60 = new Question60();
        question60.dicesProbability(3);
    }
}
