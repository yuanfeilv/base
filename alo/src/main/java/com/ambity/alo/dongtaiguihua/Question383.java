package com.ambity.alo.dongtaiguihua;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 */
public class Question383 {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        if (num==0){
            return dp;
        }
        int base = 1;
        dp[1] = 1;
        for (int i =2;i<num+1;i++){
            // 此时是2 的指数倍
            if (new Integer(i&(i-1))==0){
                dp[i]=1;
                base = i;
            }else {
                dp[i] = 1 + dp[i-base];
            }
        }
        return dp;
    }
}
