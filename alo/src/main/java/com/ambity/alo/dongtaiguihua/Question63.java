package com.ambity.alo.dongtaiguihua;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 */
public class Question63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        int[][] dp = new int[m+1][n+1];
        boolean initFlag = false;
        for (int i =1;i<=n;i++){
            if (obstacleGrid[0][i-1]==1){
                initFlag = true;
            }
            if (initFlag){
                dp[1][i] = 0;
            }else {
                dp[1][i] = 1;
            }
        }
        initFlag = false;
        for (int i =1;i<=m;i++){
            if (obstacleGrid[i-1][0]==1){
                initFlag = true;
            }
            if (initFlag){
                dp[i][1] = 0;
            }else {
                dp[i][1] = 1;
            }
        }
        if (m<2||n<2){
            return dp[m][n];
        }
        for (int i = 2;i <= m;i++){
            for (int j = 2;j <= n;j++){
                if (obstacleGrid[i-1][j-1]==1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,0}};
        System.out.println(uniquePathsWithObstacles(a));;
    }
}
