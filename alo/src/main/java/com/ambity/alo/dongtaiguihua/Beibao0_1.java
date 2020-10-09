package com.ambity.alo.dongtaiguihua;

public class Beibao0_1 {
    public static int getMax(int packWight,int num,int[]numVal,int[] numWight){
        if (num==0||packWight==0){
            return 0;
        }
        // 定义dp 数组
        int[][] dp = new int[num+1][packWight+1];
        for (int i=0;i<=num;i++){
            dp[i][0]=0;
        }
        for (int i=0;i<=packWight;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=packWight;i++){
            for (int j=1;j<=num;j++){
                if (i>=numWight[j-1]){
                    dp[j][i] = max(dp[j-1][i],numVal[j-1]+dp[j-1][i-numWight[j-1]]);
                }
            }
        }
        return dp[num][packWight];
    }
    public static int max(int a,int b){
        if (a>=b){
            return a;
        }else {
            return b;
        }
    }

    public static void main(String[] args) {
        int packWight = 5;
        int num =3;
        int[] numWight = {1,2,3};
        int[] numVal = {8,2,4};
        System.out.println(getMax(packWight,num,numVal,numWight));
    }
}
