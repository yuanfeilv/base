package com.ambity.alo.dongtaiguihua;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 1
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 * 记录 dp(i,j) 为 以 下标为i，j 为 右下点的 正方形
 * 则dp(i,j) = 1+ min (dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
 */
public class Question211 {
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i =0;i<matrix[0].length;i++){
            if (matrix[0][i] == '1'){
                dp[0][i] = 1;
                max = 1;
            }
        }
        if (matrix.length==1){
            return max;
        }
        for (int i =0;i<matrix.length;i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max= 1;
            }
        }
        if (matrix[0].length==1){
            return max;
        }

        for (int i =1;i<matrix.length;i++){
            for (int j =1;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    dp[i][j] = 1 +Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }else {
                    dp[i][j]=0;
                }
                if (dp[i][j]>max){
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','1'},{'1','1'}};
        maximalSquare(matrix);
    }
}
