package com.ambity.alo.offer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question13 {
    public int movingCount(int m, int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[][] record = new int[m][n];
        int count = 1;
        queue.addLast(0);
        queue.addLast(0);
        record[0][0] = 1;
        while (!queue.isEmpty()){
            int i = queue.pollFirst();
            int j = queue.pollFirst();
            if (check(i+1,j,m,n,k,record)){
                record[i+1][j] = 1;
                queue.addLast(i+1);
                queue.addLast(j);
                count ++;
            }
            if (check(i-1,j,m,n,k,record)){
                record[i-1][j] = 1;
                queue.addLast(i-1);
                queue.addLast(j);
                count ++;
            }
            if (check(i,j+1,m,n,k,record)){
                record[i][j+1] = 1;
                queue.addLast(i);
                queue.addLast(j+1);
                count ++;
            }
            if (check(i,j-1,m,n,k,record)){
                record[i][j-1] = 1;
                queue.addLast(i);
                queue.addLast(j-1);
                count ++;
            }
        }
        return count;
    }
    private boolean check(int i, int j, int m, int n, int k, int[][] record){
        if (i>=0 && i<m && j>=0 && j<n && (record[i][j]==0) && (i%10 + i/10 +j%10 +j/10)<=k){
            return true;
        }
        return false;
    }
}
