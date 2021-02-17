package com.ambity.alo.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 二分查找查出第一个值，然后双指针左右遍历
 */
public class Question53 {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length -1;
        boolean flag = false;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                left = mid;
                flag = true;
                break;
            }else {
                if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        if (!flag){
            return 0;
        }else {
            right = left + 1;
            left = left - 1;
            int result = 1;
            while (left>-1 && nums[left] == target){
                result ++;
                left --;
            }
            while (right<nums.length && nums[right] == target){
                result ++;
                right ++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        int target = 8;
        Question53 question53 = new Question53();
        question53.search(a,target);
    }
}
