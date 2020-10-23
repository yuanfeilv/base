package com.ambity.alo.test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 */
public class Test1 {
    public boolean isValid(String s) {
        if (s == null || s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '}'){
                if (stack.isEmpty() || stack.pop()!='{'){
                    return false;
                }
            }
            if (s.charAt(i) == ']'){
                if (stack.isEmpty() || stack.pop()!='['){
                    return false;
                }
            }
            if (s.charAt(i) == ')'){
                if (stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.isValid(")"));
        ;
    }
}
