package com.ambity.alo.offer;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 使用一个字符串维护以当前节点结尾的子字符串长度。
 */
public class Question48 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String masSub = "";
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }
        for (int i =0;i<s.length();i++){
            int index = masSub.indexOf(s.charAt(i));
            if ( index == -1){
                masSub = masSub.concat(String.valueOf(s.charAt(i)));
                max = Math.max(max,masSub.length());
            }else {
                masSub = masSub.substring(index+1,masSub.length()).concat(String.valueOf(s.charAt(i)));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "pwwkew";
        Question48 question48 = new Question48();
        System.out.println(question48.lengthOfLongestSubstring(a));
    }
}
