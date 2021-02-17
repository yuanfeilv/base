package com.ambity.alo.mianshi;

public class Question1 {
    public static boolean isUnique(String astr) {
        //128 位ascii 码
        byte[] bytes = new byte[128];
        for (int i =0;i<astr.length();i++){
            if (bytes[(int)astr.charAt(i)]==1){
                return false;
            }else {
                bytes[(int)astr.charAt(i)]=1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abc"));
    }
}
