package com.ambity.alo.offer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *dp 为以当前节点结尾的最大值
 */
public class Question42 {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0){
            return 0;
        }
        dp[0] = nums[0];
        int max = dp[0];
        for (int i =1;i<nums.length;i++){
            if (dp[i-1]>0){
                dp[i] = nums[i]+dp[i-1];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2};
        System.out.println(maxSubArray(a));
    }
}
