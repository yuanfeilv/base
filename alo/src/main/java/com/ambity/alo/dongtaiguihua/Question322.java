package com.ambity.alo.dongtaiguihua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *示例 1： 1,4,5  和为8 此时贪心算法不适合，横轴放入
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * dp[][] 横坐标表示可使用的硬币,纵坐标表示总金额 ，dp [i][j] 表示 当前最小硬币数
 * f(m,n) = min(1+f(m-a[m],n),f(m,n-1))
 *
 */
public class Question322 {
    public int coinChange(int[] coins, int amount) {
        if (amount<0){
            return -1;
        }
        int[][] dp = new int[amount+1][coins.length];
        // 初始化数组
        boolean flag = false;
        for (int i =0; i<coins.length;i++)
        {
            dp[0][i] = 0;
        }
        for (int i =1; i<=amount;i++)
        {
            if (i % coins[0] == 0){
                dp[i][0] = i / coins[0];
            }else {
                dp[i][0] = -1;
            }
        }

        for (int i =1;i<amount+1;i++){
            for (int j =1;j<coins.length;j++){
                if (i<coins[j]){
                    dp[i][j] = dp[i][j-1];
                }else {
                    if (dp[i-coins[j]][j]==-1){
                        dp[i][j] = dp[i][j-1];
                    }else {
                        dp[i][j] = Math.min(dp[i][j-1],1+dp[i-coins[j]][j]);
                    }
                }
            }
        }
        return dp[amount][coins.length-1];
    }

    public static void main(String[] args) {
        Question322 question322 = new Question322();
        int[] coins = {2,5,10,1};
        int amout = 27;
        System.out.println(question322.coinChange(coins,amout));
    }
}
