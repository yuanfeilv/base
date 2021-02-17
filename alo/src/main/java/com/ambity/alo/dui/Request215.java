package com.ambity.alo.dui;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.regex.Pattern;

/**
 * 整数数组中第K 大的数
 * 建造K 个元素的小顶堆，如果比堆顶元素大，则入堆，则每次都是替换最大的数
 */
public class Request215 {
    public static int findKthLargest(int[] nums, int k) {

        if (k>nums.length||k<1) return 0;
        int[] heap = new int[k];
        for (int j =0;j< k ;j++){
            heap[j] = Integer.MIN_VALUE;
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>heap[0]){
                // 执行堆化
                heap[0] = nums[i];
                int n =0;
                while (((2*n+1)<heap.length)){
                    // 如果有子树
                    int min = 2*n+1;
                    if (2*n+2<heap.length){
                        if (heap[2*n+1]>heap[2*n+2]){
                            min = 2 *n+2;
                        }
                    }
                    // 判断是否比子树元素大
                    if (nums[i]>heap[min]){
                        //
                        heap[n]=heap[min];
                        heap[min] = nums[i];
                        n =min;
                    }else {
                        break;
                    }

                }
            }
        }

        return heap[0];
    }

    public static void main(String[] args) {
//        int[] num = {-1,-1};
//        System.out.println(findKthLargest(num,2));
        String content="I am noob from runoob.com";
        String content2="\"message\":\"222\",\"log_path\":\"/data/logs/restpay-ali-app/info.log\",\"createtime\":\"2020-09-29T09:43:02.222\",\"partition\":\"1\",\"hostname\":\"iZ4jc05catqghp19yitt1jZ\",\"time\":1601343782,\"tag\":\"docker.10.248.70.18\"}";
        String pattern="^\\{+.*\\}$";
        System.out.println(Pattern.matches(pattern, content2));
    }
}
