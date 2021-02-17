package com.ambity.alo.dongtaiguihua;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class Question279 {
    public int numSquares(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        int a = (int) Math.floor(Math.sqrt(n));
        int[] dp = new int[n+1];
        for (int i =0;i<n+1;i++){
            dp[i]= i;
        }
        for (int i=1;i<n+1;i++){
            for (int j =1;j<a;j++){
                if ((j+1)*(j+1)<=i){
                    dp[i] = Math.min(dp[i-(j+1)*(j+1)] +1,dp[i]);
                }else {
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question279 question279 = new Question279();
        System.out.println(question279.numSquares(12));
    }
}
