package com.ambity.alo.offer;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 滑动双指针，对半查找到左指针<=target/20
 */
public class Question57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) {
                i++;
            } else if(s > target) {
                j--;
            } else {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {10,20,20,20};
        Question57 question57 = new Question57();
        int[] a = question57.twoSum(nums,40);
        System.out.println(a);
    }
}
