package com.ambity.alo.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 1 <= 数组长度 <= 50000
 */
public class Question39 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int x = 0;
        for (int num : nums){
            if (vote == 0) {
                x = num;
            }
            if (num != x){
                vote --;
            }else {
                vote ++;
            }
        }
        return x;
    }
}
