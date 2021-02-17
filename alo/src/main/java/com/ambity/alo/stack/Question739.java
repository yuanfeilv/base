package com.ambity.alo.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，
 * 至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * 两个栈，一个用来记录大小，一个用来记录下标
 */
public class Question739 {
    public int[] dailyTemperatures(int[] T) {
        if (T.length==0){
            return new int[0];
        }
        int[] result = new int[T.length];
        if (T.length==1){
            return result;
        }
        Stack<Integer> index = new Stack<>();
        index.push(0);
        for (int i =1;i<T.length;i++){
            while (!index.isEmpty()){
                if (T[index.peek()]<T[i]){
                    Integer integer = index.pop();
                    result[integer] = i-integer;
                }else {
                    break;
                }
            }
            index.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Question739 question739 = new Question739();
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] b = question739.dailyTemperatures(a);
        System.out.println(11);
        ;
    }
}
