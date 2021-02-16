package com.ambity.alo.paixu;

public class Guibing {
    public static void guibing(int[] nums, int left, int right){
        if (left>=right){
            return ;
        }
        int mid = (left+right)/2;
        guibing(nums,left,mid);
        guibing(nums,mid+1,right);
        sort(nums,left,right,mid);
    }
    public static void sort(int[] nums,int left,int right, int mid){
        int[] temp = new int[nums.length];
        int m = left;
        int n = mid + 1;
        int s = left;
        while (m<=mid && n<=right){
            if (nums[m] <= nums[n]){
                temp[s++] = nums[m++];
            }else {
                temp[s++] = nums[n++];
            }
        }
        while (m<=mid){
            temp[s ++] = nums[m ++];
        }
        while (n <= right){
            temp[s ++] = nums[n ++];
        }
        for (int i =left;i<=right;i++){
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{3,3,3,1,3};
        guibing(a,0,a.length-1);
        System.out.println(a);
    }

}
