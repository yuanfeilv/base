package com.ambity.alo.offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为
 * k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * f(n) = 当 i<n/2 时，数据 max (f(i) * f(n-i))
 */
public class Question14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        if (n<=1){
            return 0;
        }
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i =3;i<n+1;i++){
            dp[i] = i-1;
            for (int j = 2; j <= i/2; j++){
                int max = Math.max(j,dp[j]) * Math.max(i-j,dp[i-j]);
                dp[i] = Math.max(max,dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question14_1 question14_1 = new Question14_1();
        System.out.println(question14_1.cuttingRope(8));
    }
}
