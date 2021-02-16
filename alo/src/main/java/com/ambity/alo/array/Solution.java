package com.ambity.alo.array;
public class Solution {
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
        int a = array[0];
        array[0] = array[n];
        array[n] = a;
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        if (array.length == 0 || array.length == 1){
            return;
        }
        for (int i =0;i<len-1;i++){
            for (int j =1;j<len-i-1;j++){
                if (array[j]>array[0]){
                    swapWithZero(array,len-i,j);
                }
            }
            if (array[0]>array[len-i-1]){
                swapWithZero(array,len-i,len-i-1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int a = 44;
        Integer b = 44;
        Integer c = Integer.valueOf(44);
        Integer d = new Integer(44);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println(d==b);
    }
}
