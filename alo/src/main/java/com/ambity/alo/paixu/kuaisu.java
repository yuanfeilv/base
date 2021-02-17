package com.ambity.alo.paixu;

public class kuaisu {
    public static void kuaisu(int[] num,int left,int right){
        if (left>right){
            return;
        }
        int i = left;
        int j = right;
        int temp = num[left];
        while (i<j){
            // 从右向左找一个更小的数
            while (i<j && num[j] >= temp){
                j--;
            }

            while (i<j && temp >= num[i]){
                i++;
            }
            // 交换
            if (i<j) {
                int a = num[i];
                num[i] = num[j];
                num[j] = a;
            }
        }
        num[left] = num[i];
        num[i] = temp;
        kuaisu(num,left,i-1);
        kuaisu(num,i+1,right);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,2,2,2,2,2};
        kuaisu(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
