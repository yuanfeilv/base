package com.ambity.alo.dongtaiguihua;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 1~n-1 的最大不相邻值，
 * dp 数组 包含i 的 最大钱
 */
public class Question213 {
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] a = new int[nums.length-1];
        System.arraycopy(nums,0,a,0,nums.length-1);
        int[] b = new int[nums.length-1];
        System.arraycopy(nums,1,b,0,nums.length-1);
        return Math.max(robMax(a),robMax(b));
    }
    public int robMax(int[] nums){
        if (nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        if (nums.length==1){
            return dp[1];
        }
        for (int i =1;i<nums.length;i++){
            dp[i+1] = Math.max(nums[i]+dp[i-1],dp[i]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] ints = {1,2};
        Question213 question213 = new Question213();
        System.out.println(String.valueOf(question213.rob(ints)));
    }
}
