package com.ambity.alo.dongtaiguihua;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 假定dp 数组是以i 结尾的最大数
 */
public class question53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i =1;i<nums.length;i++){
            if (nums[i]>nums[i]+dp[i-1]){
                dp[i] = nums[i];
            }else {
                dp[i] = nums[i]+dp[i-1];
            }
            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {4,-1,2,1};
        System.out.println(maxSubArray(num));
    }
}
