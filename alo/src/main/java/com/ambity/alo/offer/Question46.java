package com.ambity.alo.offer;

/**
 *给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * f(n) 为以当前节点结尾的个数，那么f(n) = f(n-1) + 当 s(n-1)s(n) 在10~25 之间，则 + f(n-2)
 */
public class Question46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length()==1){
            return 1;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1; dp[1] = 1;
        for (int i =2;i<=s.length();i++){
            Integer integer = Integer.valueOf(s.substring(i-2,i));
            if (integer>9 && integer <26){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "1234567";
        for (int i =2;i<=s.length();i++){
            Integer integer = Integer.valueOf(s.substring(i-2,i));
            System.out.println(integer);
//            if ()
        }
    }
}
