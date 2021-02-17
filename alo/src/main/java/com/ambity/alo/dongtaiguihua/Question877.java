package com.ambity.alo.dongtaiguihua;

import java.util.Arrays;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ i 是 楼层， j 是鸡蛋个数
 *  如果在 第a 层 没有碎，那么 f(n-a,k)+1
 *                 如果碎了，那么 f(a-1,k-1)+1 最坏情况就是他们的最大值
 *
 */
public class Question877 {

    /**
     * 记忆集的写法
     * @param K
     * @param N
     * @return
     */
//    public int superEggDrop(int K, int N) {
//        int[][] dp = new int[K+1][N+1];
//        return superEgg(K,N,dp);
//    }
//
//    public int superEgg(int K,int N,int[][] dp){
//        if (N==0){
//            return 0;
//        }
//        if (K==1){
//            return N;
//        }
//        if (dp[K][N]!=0){
//            return dp[K][N];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i =1;i<N+1;i++){
//            int result = 1 + Math.max(superEgg(K-1,i-1,dp),superEgg(K,N-i,dp));
//            res  = Math.min(res,result);
//        }
//        return res;
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }

        // 初始化：填写下标为 0、1 的行和下标为 0、1 的列
        // 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }

        // 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }

        // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
        // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度（想想复杂度的定义）
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        for (int i =2;i<N+1;i++){
            for (int j =2;j<K+1;j++){
                // 普通dp 解，超时
//                for (int p =1;p<=i;p++){
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[p - 1][j - 1], dp[i - p][j]) + 1);
//                }
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        Question877 question877 = new Question877();
        System.out.println(question877.superEggDrop(3,13));
    }
}
