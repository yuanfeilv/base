package com.ambity.alo.offer;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 记录从左向右与从右向左两个dp ，分表表示0-i 与 n->n-i 的 值
 */
public class Question66 {
    public int[] constructArr(int[] a) {
        if (a.length==0){
            return new int[]{};
        }
        if (a.length == 1){
            return a;
        }

        int[] dp_left = new int[a.length-1];
        int[] dp_right = new int[a.length-1];
        dp_left[0] =a[0];
        int c = a.length;
        dp_right[0] = a[c-1];
        int[] result = new int[c];
        for (int i =1;i<c-1;i++){
            dp_left[i] = dp_left[i-1] * a[i];
            dp_right[i] = dp_right[i-1] * a[c-1-i];
        }
        result[0] = dp_right[c-2];
        result[c-1] = dp_left[c-2];
        for (int i =1;i<c-1;i++){
            result[i] = dp_left[i-1] *dp_right[c-2-i];
        }
        return result;
    }

    public static void main(String[] args) {
        Question66 question66 = new Question66();
        int[] a = new  int[]{1,-2};
        System.out.println(question66.constructArr(a));
    }
}
