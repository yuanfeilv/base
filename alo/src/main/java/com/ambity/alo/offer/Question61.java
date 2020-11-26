package com.ambity.alo.offer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Question61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt=0,diff=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                zeroCnt++;
            }else{
                if(nums[i]==nums[i+1]) {
                    return false;
                }
                if(nums[i]+1!=nums[i+1]){
                    diff+=nums[i+1]-nums[i]-1;
                }
            }
        }
        return zeroCnt>=diff;
    }
}
