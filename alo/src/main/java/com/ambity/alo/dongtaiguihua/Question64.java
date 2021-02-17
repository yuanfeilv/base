package com.ambity.alo.dongtaiguihua;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 状态转移方程 f(m,n) = grid[m-1][n-1] + min(f(m-1,n),f(m,n-1))
 * 28 分钟
 */
public class Question64 {
    public static int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int m = grid[0].length;
        int n = grid.length;
        // 初始化基础数组
        int[][] dp = new int[n][m];
        // 初始化第一行
        dp[0][0] = grid[0][0];
        for (int i =1;i<m;i++){
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }
        if (n==1){
            return dp[0][m-1];
        }else {
            for (int i =1;i<n;i++){
                dp[i][0] = grid[i][0]+dp[i-1][0];
            }
        }
        for (int i =1;i<n;i++){
            for (int j =1; j<m;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] a = {{1,3,1},{1,5,1}};
        System.out.println(minPathSum(a));
        ;
    }
}
