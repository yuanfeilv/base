package com.ambity.alo.dongtaiguihua;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *  拆成 a 和 b 那么 最大值就是 max 本身 或者 f(a)+f(b)
 */
public class Question343 {
    public int integerBreak(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n==1){
            return dp[n-1];
        }
        dp[1] = 1;
        if (n==2){
            return dp[n-1];
        }
        for (int i = 3;i<n+1;i++){
            int max = i-1;
            for (int j =2;j<=i/2;j++){
                max = Math.max(max,Math.max(dp[j-1],j)*Math.max(dp[i-j-1],i-j));
            }
            dp[i-1] = max;
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        Question343 question343 = new Question343();
        System.out.println(question343.integerBreak(10));
    }
}
