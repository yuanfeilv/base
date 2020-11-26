package com.ambity.alo.offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class Question58 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] a = s.split(" ");
        if (s.length()==0){
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = a.length-1;i>0;i--){
            if (a[i].trim().length()==0){
                continue;
            }
            stringBuffer.append(a[i]).append(" ");
        }
        stringBuffer.append(a[0]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String a = "i  am";
        Question58 question58 = new Question58();
        System.out.println(question58.reverseWords(a));
    }
}
