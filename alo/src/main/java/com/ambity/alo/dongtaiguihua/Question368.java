package com.ambity.alo.dongtaiguihua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 */
public class Question368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }
        List<String> list1 = new ArrayList<>();
        if (nums.length == 1){
            List<Integer> max = new ArrayList<>();
            max.add(nums[0]);
            return max;
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> max = new ArrayList<>();
        max.add(nums[0]);
        lists.add(max);
        for (int i=1;i<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            for (int j =i-1;j>=0;j--){
                if (nums[i]%nums[j] == 0 ){
                    if (lists.get(j).size()>list.size()){
                        list = new ArrayList<Integer>(lists.get(j));
                    }
                }
            }
            list.add(nums[i]);
            if (list.size()>max.size()){
                max = list;
            }
            lists.add(list);
        }
        return max;
    }

    public static void main(String[] args) {
        Question368 question368 = new Question368();
        System.out.println(question368.largestDivisibleSubset(new int[]{1,2,3,6}).size());
        ;
    }
}
