package com.ambity.alo.dongtaiguihua;

/**
 *
 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 题目数据保证答案肯定是一个 32 位的整数。fn = f(n-1)+ if a[n]<6 and a[n-1]<2?
 */
public class Question91 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i + 1] = dp[i];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];

    }

    public static void main(String[] args) {
        Question91 question91 = new Question91();
        ;
        System.out.println(question91.numDecodings("12"));
    }
}
