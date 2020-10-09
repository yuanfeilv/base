package com.ambity.alo.string;

// 最长回文子串，双指针解决
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        // 记录位置
        String palindrome = s.substring(0,1);
        for (int position=1;position<=s.length()-1;position++){
            // 当position 位置为单数时
            int left = position;
            int right = position;
            while (left > 0&&right <s.length()-1){
                if (s.charAt(left-1)==s.charAt(right+1)){
                    left--;
                    right++;
                }else {
                    break;
                }
            }
            if (right+1-left>palindrome.length()){
                palindrome = s.substring(left,right+1);
            }
            // 偶数的情况
            if (s.charAt(position)==s.charAt(position-1)){
                left = position-1;
                right=position;
                while (left > 0&&right <s.length()-1){
                    if (s.charAt(left-1)==s.charAt(right+1)){
                        left--;
                        right++;
                    }else {
                        break;
                    }
                }
                if (right+1-left>palindrome.length()){
                    palindrome = s.substring(left,right+1);
                }
            }

        }

        return palindrome;
    }

    public static void main(String[] args) {
        String string = "abacccccdcccccc";
        System.out.println(longestPalindrome(string));
    }
}
