package com.ambity.alo.dongtaiguihua;

import javax.validation.constraints.Max;
import java.util.Stack;

/**
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 输入：matrix =[
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 *  dp 是以当前节点为右下节点的 最大举行的 长和宽
 */
public class Question85 {
    public static void main(String[] args) {
        Question85 question85 = new Question85();

        char[][] a = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(question85.maximalRectangle(a));
    }
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if (matrix.length==0){
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        for (int i =0; i < matrix.length;i ++){
            for (int j =0; j < matrix[0].length;j ++){
                if (matrix[i][j] == '0'){
                    dp[j] = 0;
                }else {
                    dp[j] = dp[j] + 1;
                }
            }
            max = Math.max(largestRectangleArea(dp),max);
        }
        return max;
    }
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
}
