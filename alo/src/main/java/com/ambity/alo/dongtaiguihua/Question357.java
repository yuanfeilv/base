package com.ambity.alo.dongtaiguihua;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * f(n+1) = f(n) + 9*(9)*...*(9)
 */
public class Question357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n<=0){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 10;
        int temp = 9;
        for (int i =1;i<n;i++){
            if (i<9){
                temp = temp * (9-i+1);
                dp[i] = dp[i-1]+temp;
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Question357 question357 = new Question357();
        System.out.println(question357.countNumbersWithUniqueDigits(3));
        System.out.println(9*9*8+91+10);
    }
}
