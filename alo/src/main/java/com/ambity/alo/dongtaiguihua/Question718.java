package com.ambity.alo.dongtaiguihua;

/**
 * 给两个整数数组，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * dp(i,j) 是以第一个数组i 个元素结尾 第二个数组的第j 个元素结尾的最大子数组的长度
 */
public class Question718 {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        if (A.length == 0 || B.length == 0){
            return 0;
        }
        int [][] dp = new int[A.length][B.length];
        dp[0][0] = A[0] == B[0]?1:0;
        for (int i = 1;i<A.length;i++){
            if (A[i] == B[0]){
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 1;i<B.length;i++){
            if (B[i] == A[0]){
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i =1;i<A.length;i++){
            for (int j =1;j<B.length;j++){
                if (A[i] == B[j]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j],max);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {};
        int[] B = {1,3};
        Question718 question718 = new Question718();
        System.out.println(question718.findLength(A,B));
    }
}
