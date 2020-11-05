package com.ambity.alo.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Question21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int swap = 0;
        while (left<right){
            while (new Integer(nums[left] & 1) == 1 && left < nums.length-1){
                left ++;
            }
            while (new Integer(nums[right] & 1 ) == 0 && right > 0){
                right --;
            }
            if (left<right){
                swap = nums[left];
                nums[left] = nums[right];
                nums[right] = swap;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Question21 question21 = new Question21();
        int[] a = {};
        System.out.println(question21.exchange(a));
    }
}
