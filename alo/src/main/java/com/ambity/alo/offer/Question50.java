package com.ambity.alo.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 */
public class Question50 {
    public char firstUniqChar(String s) {
        List<Character> characters = new ArrayList<>();
        int index = -1;
        if (s.length() == 0){
            return ' ';
        }
        if (s.length() == 1){
            return s.charAt(0);
        }
        int[] dp = new int[26];
        for (int i =0;i<s.length();i++){
            if (dp[s.charAt(i) - 'a'] == 0){
                characters.add(s.charAt(i));
                dp[s.charAt(i) - 'a'] ++;
            }else {
                characters.remove(Character.valueOf(s.charAt(i)));
            }
        }
        if (characters.size()>0){
            return characters.get(0);
        }else {
            return ' ';
        }
    }

    public static void main(String[] args) {
        Question50 question50 = new Question50();
        System.out.println(question50.firstUniqChar("leetcode"));
    }
}
