package com.ambity.alo.test;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class Test3 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i =0;i<tokens.length;i++){
            switch (tokens[i]){
                case "*":
                    stack.push(String.valueOf(Integer.valueOf(stack.pop())*Integer.valueOf(stack.pop())));
                    break;
                case "+":
                    stack.push(String.valueOf(Integer.valueOf(stack.pop())+Integer.valueOf(stack.pop())));
                    break;
                case "/":
                    Integer val1 = Integer.valueOf(stack.pop());
                    Integer val2 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(val2/val1));
                    break;
                case "-":
                    Integer val3 = Integer.valueOf(stack.pop());
                    Integer val4 = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(val4-val3));
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
