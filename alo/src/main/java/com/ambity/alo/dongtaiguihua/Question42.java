package com.ambity.alo.dongtaiguihua;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1]
 *                0,1,0,2,1,0,1,3,2,1,2,1
 *                0,1,1,2,2,2,2,3,3,3,3,3
 *                3,3,3,3,3,3,3,3,2,2,2,1
 *                0,0,1,0,1,2,1,0,0,1,0,0
 *
 * 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 一个点能接到雨水，就是前面有比他大的值，后面有比他大的值
 * 即2个dp
 */
public class Question42 {
    public int trap(int[] height) {
        if (height.length<3){
            return 0;
        }
        int length = height.length;
        int max_left = height[0];
        int max_right = height[length-1];
        int[] dp_left = new int[length];
        int[] dp_right = new int[length];
        for (int i =1;i<length;i++){
            if (height[i]>max_left){
                max_left = height[i];
            }
            dp_left[i] = max_left;
            if (height[length-1-i]>max_right){
                max_right = height[length-1-i];
            }
            dp_right[length-1-i] = max_right;
        }
        int result = 0;
        for (int i=1;i<length-1;i++){
            result = result + Math.min(dp_left[i],dp_right[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4,2,0};
        Question42 question42 = new Question42();
        System.out.println(question42.trap(a));
    }
}
