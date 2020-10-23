package com.ambity.alo.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Question17 {
    public List<String> letterCombinations(String digits) {
        List<String> a = new ArrayList<>();
        if ("".equals(digits)){
            return a;
        }
        combinations(digits,a,"");
        return a;
    }
    public void combinations(String digits, List<String> list,String dig){
        if (digits.length()==dig.length()){
            list.add(dig);
            return;
        }
        char now = digits.charAt(dig.length());
        String choose = getString(now);
        for (int i =0;i< choose.length();i++){
            dig = dig + choose.charAt(i);
            combinations(digits,list,dig);
            dig = dig.substring(0,dig.length()-1);
        }
    }
    public String getString(char a){
        switch (a){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        List<String> a = question17.letterCombinations("");
        System.out.println(a);
    }
}
