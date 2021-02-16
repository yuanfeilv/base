package com.ambity.alo.dongtaiguihua;

import java.util.Arrays;

/**
 * 给定一个非负整数数组和一个整数m，你需要将这个数组分成m个非空的连续子数组。
 * 设计一个算法使得这m个子数组各自和的最大值最小。
 * 注意:
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * nums = [7,2,5,10,8]
 * m = 2
 * 输出:
 * 18
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * n 代表数组长度
 *  对于从 下标 m 到 n 取 值i ,那么f(0~i-1,m-1) 与 sum(i,n-1) 的最大值 那么f(m,n) 便是取其中的最小值
 */
public class Question410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
