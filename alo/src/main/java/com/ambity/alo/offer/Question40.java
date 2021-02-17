package com.ambity.alo.offer;

import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 */
public class Question40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k <1){
            return new int[]{};
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i : arr){
            priorityQueue.add(i);
        }
        int[] result = new int[k];
        for (int i = 0;i < k;i ++){
            result[i] = priorityQueue.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1};
        Question40 question40 = new Question40();
        System.out.println(question40.getLeastNumbers(a,2));
    }
}
