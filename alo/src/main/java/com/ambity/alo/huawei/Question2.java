package com.ambity.alo.huawei;

public class Question2 {
    public int getLength(String s,int length){
        int max = 0;
        for (int i =2;i<=length;i++){
            String a = s.substring(0,i);
            int amaxlength = a.length()-1;
            int mid = a.length()/2;
            for (int j = amaxlength;j>=mid;j--){
                if (isTrue(a,a.substring(0,j))){
                    max = max + a.substring(0,j).length();
                    System.out.println(a+":"+a.substring(0,j));
                    break;
                }
            }
        }
        return max;
    }
    // 判断b 是否是a 的重复词
    public boolean isTrue(String a,String b){
        if (a.length()>b.length() &&
        a.indexOf(b)>-1
                &&(b+b).indexOf(a)>-1
        ){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        int a = question2.getLength("abababab",8);
        System.out.println(a);

    }
}
