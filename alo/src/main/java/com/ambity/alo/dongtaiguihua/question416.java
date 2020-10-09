package com.ambity.alo.dongtaiguihua;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 计算出 和，求二分之一，转换成背包问题，即 前 n 个数是否能等于0~二分之一的值
 */
public class question416 {
    public static boolean canPartition(int[] nums) {
        if (nums.length<2){
            return false;
        }
        // 计算和
        int all = 0;
        for(int i=0;i<nums.length;i++){
            all +=nums[i];
        }
        if (all%2==1){
            return false;
        }else {
            all = all/2;
        }
        boolean[][] dp = new boolean[nums.length+1][all+1];
        for (int i =0;i<=nums.length;i++){
            dp[i][0] = true;
        }
        for (int i =0;i<=all;i++){
            dp[0][i] = false;
        }
        for (int i=1;i<=nums.length;i++){
            for (int j=1;j<=all;j++){
               if (j<nums[i-1]){
                    dp[i][j] = dp[i-1][j];
               }else {
                   dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i-1]];
               }
            }
        }
        return dp[nums.length][all];
    }

    public static void main(String[] args) {
        int[] num = {1, 5, 1, 5};
        System.out.println(canPartition(num));
    }
}
