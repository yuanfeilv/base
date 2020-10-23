//package com.ambity.alo.test;
//
//import java.util.*;
//
///**
// * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
// *
// *
// *
// * 示例 1:
// *
// * 输入: nums = [1,1,1,2,2,3], k = 2
// * 输出: [1,2]
// * 示例 2:
// *
// * 输入: nums = [1], k = 1
// * 输出: [1]
// */
//public class Test2 {
//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap hashMap = new HashMap();
//
//        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                if (o1.getValue()>o2.getValue()){
//                    return -1;
//                }else {
//                    return 1;
//                }
//            }
//        });
//        for (int i = 0;i<nums.length;i++){
//            priorityQueue.size()
//        }
//
//    }
//
//}
