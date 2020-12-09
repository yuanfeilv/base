package com.ambity.alo.dongtaiguihua;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 *
 * 输入: [6,7,5,2,4,5,9,3]
 * −1,0,−1,−1,3,4,5,3
 * 2,2,3,8,7,7,7,8
 * 单调栈解法
 */
public class Question84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length==0){
            return 0;
        }
        if (heights.length==1){
            return heights[0];
        }
        // 左单调栈
        int length = heights.length;
        int[] dp_left = new int[length];
        int[] dp_right = new int[length];
        dp_left[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i =1;i<length;i++){
            while (!stack.isEmpty()){
                if (heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }else {
                    break;
                }
            }
            if (stack.isEmpty()){
                dp_left[i] = -1;
            }else {
                dp_left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        dp_right[length-1] = length;
        stack.push(length-1);
        //6,7,5,2,4,5,9,3
        for (int i =length-2;i>=0;i--){
            while (!stack.isEmpty()){
                if (heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }else {
                    break;
                }
            }
            if (stack.isEmpty()){
                dp_right[i] = length;
            }else {
                dp_right[i] = stack.peek();
            }
            stack.push(i);
        }
        int max = heights[0];
        for (int i =0;i<length;i++){
            max = Math.max(heights[i] * (dp_right[i]-dp_left[i]-1),max);
        }
        return max;
    }

    public static void main(String[] args) {
        Question84 question84 = new Question84();
        int[] a = {6,7,5,6};
        System.out.println(question84.largestRectangleArea(a));
    }
}
